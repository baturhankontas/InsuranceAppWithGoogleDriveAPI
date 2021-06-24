package com.accenture.insurance.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.accenture.insurance.services.CustomerService;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.accenture.insurance.InsuranceAppApplication.class)
public class CustomerControllerTest {
	
	@MockBean
	CustomerService serv;
	
	@Autowired
	MockMvc mvc;
	
	@Test
	void createCustomerTest() throws Exception{
		
	}
	
	@Test
	void getCustomerTest() throws Exception{
		
	}
	
	@Test
	void getAllCustomerTest() throws Exception{
		
	}
	
	@Test
	void updateCustomerTest() throws Exception{
		
	}
	
	@Test
	void deleteCustomerTest() throws Exception{
		
	}

}
