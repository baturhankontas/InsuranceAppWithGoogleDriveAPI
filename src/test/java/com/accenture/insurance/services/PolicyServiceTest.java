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

import com.accenture.insurance.beans.Policy;
import com.accenture.insurance.repos.PolicyRepo;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.accenture.insurance.InsuranceAppApplication.class)
public class PolicyServiceTest {

	@MockBean
	PolicyRepo repo;
	
	@Autowired
	PolicyService serv;
	
	@Test
	void createPolicyTest() {
		int id=1;
		Policy obj = new Policy();
		obj.setPol_Number(id);
		Mockito.when(repo.save(obj)).thenReturn(obj);
		
		obj=serv.createPolicy(obj);
		Assertions.assertEquals(1, obj.getPol_Number());
	}
	
	@Test
	void getPolicyTest() {
		int id=1;
		Policy obj = new Policy();
		obj.setPol_Number(id);
		Mockito.when(repo.findById(id)).thenReturn(Optional.of(obj));
		
		obj=serv.getPolicyById(id);
		Assertions.assertEquals(id, obj.getPol_Number());
	}
	
	@Test
	void getAllPoliciesTest() {
		List<Policy> allPol =new ArrayList<Policy>();
		Mockito.when(repo.findAll()).thenReturn(Stream.of(new Policy(), new Policy(), new Policy()).collect(Collectors.toList()));
		
		allPol = serv.getAllPolicies();
		Assertions.assertEquals(3, allPol.size());

	}
	
	@Test
	void updatePolicyTest() {
		Policy obj = new Policy();
		obj.setPol_Number(1);
		
		Mockito.when(repo.save(obj)).thenReturn(obj);
		
		Assertions.assertEquals(1, obj.getPol_Number());		
		obj.setPol_Number(2);
		obj = serv.updatePolicy(obj);
		Assertions.assertEquals(2, obj.getPol_Number());
	}
	
	@Test
	void deletePolicyTest() {
		int id=1;
		Policy obj = new Policy();
		obj.setPol_Number(id);
		Mockito.when(repo.findById(id)).thenReturn(Optional.of(obj));
		
		Assertions.assertEquals(true, serv.deletePolicy(id));
		verify(repo, times(1)).delete(obj);
	}
}
