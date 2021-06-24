package com.accenture.insurance.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.accenture.insurance.services.PolicyService;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.accenture.insurance.InsuranceAppApplication.class)
public class PolicyControllerTest {

	@MockBean
	PolicyService serv;
	
	@Autowired
	MockMvc mvc;
	
	@Test
	void createPolicyTest() throws Exception{
		
	}
	
	@Test
	void getPolicyTest() throws Exception{
		
	}
	
	@Test
	void getAllPolicyTest() throws Exception{
		
	}
	
	@Test
	void updatePolicyTest() throws Exception{
		
	}
	
	@Test
	void deletePolicyTest() throws Exception{
		
	}
	
}
