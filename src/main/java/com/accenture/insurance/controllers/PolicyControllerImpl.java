package com.accenture.insurance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.insurance.beans.Policy;
import com.accenture.insurance.services.PolicyService;

@RestController
public class PolicyControllerImpl implements PolicyController {

	@Autowired
	private PolicyService ps;
	
	@Override
	@PostMapping(value = "/policies", consumes = "application/json", produces = "application/json")
	public Policy createPolicy(@RequestBody Policy p) {
		// TODO Auto-generated method stub
		try {
			return ps.createPolicy(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@GetMapping(value = "/policies/{id}")
	public Policy getPolicy(@PathVariable("id") int id) {
		// TODO Auto-generated method stub
		try {
			return ps.getPolicyById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@GetMapping(value="/policies")
	public List<Policy> getAllPolicy() {
		// TODO Auto-generated method stub
		System.out.println("asdasfasdfas");
		try {
			
			return ps.getAllPolicies();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@PutMapping(value = "/policies/{id}", consumes = "application/json")
	public Policy updatePolicy(@PathVariable("id") int id, @RequestBody Policy p) {
		// TODO Auto-generated method stub
		try {
			p.setPol_Number(id);
			return ps.updatePolicy(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@DeleteMapping(value = "/policies/{id}")
	public boolean deletePolicy(@PathVariable("id") int id) {
		// TODO Auto-generated method stub
		try {
			return ps.deletePolicy(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@GetMapping(value = "/policiesAll/{type}")
	public List<Policy> getAllPoliciesByType(@PathVariable("type") int type) {
		// TODO Auto-generated method stub
		try {
			return ps.getAllPoliciesByType(type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@GetMapping(value = "/policiesAllByUserId/{cust_id}")
	public List<Policy> getAllPoliciesByUserId(@PathVariable("cust_id") int cust_id) {
		// TODO Auto-generated method stub
		try {
			return ps.getAllPoliciesByUserId(cust_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
