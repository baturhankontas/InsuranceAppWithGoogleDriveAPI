package com.accenture.insurance.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.accenture.insurance.beans.Address;
import com.accenture.insurance.repos.AddressRepo;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.accenture.insurance.InsuranceAppApplication.class)
public class AddressServiceTest {

	@MockBean
	AddressRepo repo;
	
	@Autowired
	AddressService serv;
	
	@Test
	void createAddressTest() {
		int id=1;
		Address obj = new Address();
		obj.setAdd_Id(id);
		Mockito.when(repo.save(obj)).thenReturn(obj);
		
		obj=serv.createAddress(obj);
		Assertions.assertEquals(1, obj.getAdd_Id());
	}
	
	@Test
	void getAddressTest() {
		int id=1;
		Address obj = new Address();
		obj.setAdd_Id(id);
		Mockito.when(repo.findById(id)).thenReturn(Optional.of(obj));
		
		obj=serv.getAddress(id);
		Assertions.assertEquals(id, obj.getAdd_Id());
	}
	
	@Test
	void getAllAddressesTest() {
		List<Address> allAdd =new ArrayList<Address>();
		Mockito.when(repo.findAll()).thenReturn(Stream.of(new Address(), new Address(), new Address()).collect(Collectors.toList()));
		
		allAdd = serv.getAllAddresses();
		Assertions.assertEquals(3, allAdd.size());
	}
	
	@Test
	void updateAddressTest() {
		Address obj = new Address();
		obj.setAdd_Id(1);
		
		Mockito.when(repo.save(obj)).thenReturn(obj);
		
		Assertions.assertEquals(1, obj.getAdd_Id());		
		obj.setAdd_Id(2);;
		obj = serv.updateAddress(obj);
		Assertions.assertEquals(2, obj.getAdd_Id());
	}
	
	@Test
	void deleteAddressTest() {
		int id=1;
		Address obj = new Address();
		obj.setAdd_Id(id);
		Mockito.when(repo.findById(id)).thenReturn(Optional.of(obj));
		
		Assertions.assertEquals(true, serv.deleteAddress(id));
		verify(repo, times(1)).delete(obj);
	}
	
}
