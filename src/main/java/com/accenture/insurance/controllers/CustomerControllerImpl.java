package com.accenture.insurance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.insurance.beans.Customer;
import com.accenture.insurance.services.CustomerService;

@RestController
@CrossOrigin
public class CustomerControllerImpl implements CustomerController {
	
	@Autowired
	CustomerService cs;

	@Override
	@GetMapping(value="/customers/{id}")
	public Customer getCustomer(@PathVariable("id") int id) {
		// TODO Auto-generated method stub
		try {
			return cs.getCustomer(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@GetMapping(value = "/customers")
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		try {
			return cs.getAllCustomers();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@PostMapping(value = "/customers", consumes = "application/json", produces = "application/json")
	public Customer createCustomer(@RequestBody Customer c) {
		// TODO Auto-generated method stub
		try {
			return cs.createCustomer(c);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@PutMapping(value="/customers/{id}", consumes="application/json")
	public Customer updateCustomer(@PathVariable("id") int id, @RequestBody Customer c) {
		// TODO Auto-generated method stub
		try {
			c.setCust_Id(id);
			return cs.updateCustomer(c);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@DeleteMapping(value="/customers/{id}")
	public boolean deleteCustomer(@PathVariable("id") int id) {
		// TODO Auto-generated method stub
		try {
			return cs.deleteCustomer(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@GetMapping(value="/customers/address/{id}", produces="application/json")
	public Customer getCustomerByAddress(@PathVariable("id") int add_id) {
		// TODO Auto-generated method stub
		try {
			Customer c = cs.getCustomerByAddress(add_id);
			return c;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
