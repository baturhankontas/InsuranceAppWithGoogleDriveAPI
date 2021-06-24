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

import com.accenture.insurance.beans.Customer;
import com.accenture.insurance.repos.CustomerRepo;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.accenture.insurance.InsuranceAppApplication.class)
public class CustomerServiceTest {
	
	@MockBean
	CustomerRepo repo;
	
	@Autowired
	CustomerService serv;
	
	@Test
	void createCustomerTest() {
		int id=1;
		Customer obj = new Customer();
		obj.setCust_Id(id);
		Mockito.when(repo.save(obj)).thenReturn(obj);
		
		obj=serv.createCustomer(obj);
		Assertions.assertEquals(1, obj.getAdd_Id());
	}
	
	@Test
	void getCustomerTest() {
		int id=1;
		Customer obj = new Customer();
		obj.setCust_Id(id);
		Mockito.when(repo.findById(id)).thenReturn(Optional.of(obj));
		
		obj=serv.getCustomer(id);
		Assertions.assertEquals(id, obj.getAdd_Id());
	}
	
	@Test
	void getAllCustomersTest() {
		List<Customer> allCus =new ArrayList<Customer>();
		Mockito.when(repo.findAll()).thenReturn(Stream.of(new Customer(), new Customer(), new Customer()).collect(Collectors.toList()));
		
		allCus= serv.getAllCustomers();
		Assertions.assertEquals(3, allCus.size());
	}
	
	@Test
	void updateCustomerTest() {
		Customer obj = new Customer();
		obj.setCust_Id(1);
		
		Mockito.when(repo.save(obj)).thenReturn(obj);
		
		Assertions.assertEquals(1, obj.getAdd_Id());		
		obj.setCust_Id(2);
		obj = serv.updateCustomer(obj);
		Assertions.assertEquals(2, obj.getAdd_Id());
	}
	
	@Test
	void deleteCustomerTest() {
		int id=1;
		Customer obj = new Customer();
		obj.setCust_Id(id);
		Mockito.when(repo.findById(id)).thenReturn(Optional.of(obj));
		
		Assertions.assertEquals(true, serv.deleteCustomer(id));
		verify(repo, times(1)).delete(obj);
	}

}
