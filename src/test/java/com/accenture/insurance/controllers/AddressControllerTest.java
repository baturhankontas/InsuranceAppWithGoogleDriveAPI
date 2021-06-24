package com.accenture.insurance.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import com.accenture.insurance.beans.Address;
import com.accenture.insurance.services.AddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.accenture.insurance.InsuranceAppApplication.class)
public class AddressControllerTest {

	@MockBean
	AddressService serv;
	
	@Autowired
	MockMvc mvc;
	
	public static Gson gson= new Gson();
	
	@Test
	void createAddressTest() throws Exception{
		Address obj = new Address();
		obj.setAdd_Id(1);
		obj.setCity("miami");
		obj.setCountry("usa");
		obj.setLine1("asdasd");
		obj.setLine2("asdas");
		obj.setState("nc");
		obj.setZip(12345);
		
		Address badObj = new Address();
		
		ObjectMapper om = new ObjectMapper();
		String jsonRequest = om.writeValueAsString(obj);
		
		Mockito.when(serv.createAddress(ArgumentMatchers.eq(obj))).thenReturn(obj);
		Mockito.when(serv.createAddress(ArgumentMatchers.eq(badObj))).thenThrow(NullPointerException.class);
		
		ResultActions ra = mvc.perform(post("/address").contentType(MediaType.APPLICATION_JSON).content(jsonRequest));
		ra.andExpect(status().isOk());
		ra.andExpect(jsonPath("$.id", is(1)));
		
		ra = mvc.perform(post("/address").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(badObj)));
		ra.andExpect(status().isOk());
		ra.andExpect((ResultMatcher) content().string(""));	
	}
	
	@Test
	void getAddressTest() throws Exception{
		int id=1;
		Address obj = new Address();
		obj.setAdd_Id(id);
		
		Mockito.when(serv.getAddress(1)).thenReturn(obj);
		Mockito.when(serv.getAddress(0)).thenThrow(NoSuchElementException.class);
		
		ResultActions ra = mvc.perform(get("/address/" + id));
		ra.andExpect(status().isOk());
		ra.andExpect(jsonPath("$.id", is(id)));
		
		ra = mvc.perform(get("/address/0"));
		ra.andExpect(status().isOk());
		ra.andExpect((ResultMatcher) content().string(""));	
	}
	
	@Test
	void getAllAddressesTest() throws Exception{
		Mockito.when(serv.getAllAddresses()).thenReturn(Stream.of(new Address(), new Address(), new Address()).collect(Collectors.toList()));		
		ResultActions ra = mvc.perform(get("/address"));
		ra.andExpect(status().isOk());
		ra.andExpect(jsonPath("$.length()", is(3)));
	}
	
	@Test
	void updateAddressTest() throws Exception{
		int id = 1;
		Address obj = new Address();
		obj.setAdd_Id(id);
		Address testObj = new Address();
		testObj.setAdd_Id(2);
		
		Mockito.when(serv.updateAddress(obj)).thenReturn(obj); //ArgumentMatchers.eq() not needed when using Gson
		Mockito.when(serv.updateAddress(testObj)).thenThrow(NullPointerException.class);
		
		ResultActions ra = mvc.perform(put("/address/1").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(obj)));
		ra.andExpect(status().isOk());
		ra.andExpect(jsonPath("$.id", is(1)));
		
		ra = mvc.perform(put("/address/2").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(testObj)));
		ra.andExpect(status().isOk());
	}
	
	@Test
	void deleteAddressTest() throws Exception{
		int id = 1;
		int badID = 2;
		
		Mockito.when(serv.deleteAddress(id)).thenReturn(true);
		Mockito.when(serv.deleteAddress(badID)).thenThrow(NoSuchElementException.class);
		
		ResultActions ra = mvc.perform(delete("/address/" + id));
		ra.andExpect(status().isOk());
		ra.andExpect((ResultMatcher) content().string("true"));
		
		ra = mvc.perform(delete("/address/" + badID));
		ra.andExpect(status().isOk());
		ra.andExpect((ResultMatcher) content().string("false"));
	}
	
}
