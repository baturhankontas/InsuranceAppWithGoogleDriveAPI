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

import com.accenture.insurance.beans.Address;
import com.accenture.insurance.services.AddressServiceImpl;

@RestController
public class AddressControllerImpl implements AddressController {

	@Autowired
	private AddressServiceImpl as;
	
	@Override
	@PostMapping(value = "/address", consumes = "application/json", produces = "application/json")
	public Address createAddress(@RequestBody Address a) {
		// TODO Auto-generated method stub
		try {
			return as.createAddress(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@GetMapping(value = "/address/{id}")
	public Address getAddress(@PathVariable("id") int id) {
		// TODO Auto-generated method stub
		try {
			return as.getAddress(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@GetMapping(value = "/getAllAddress")
	public List<Address> getAllAddresses() {
		// TODO Auto-generated method stub
		try {
			System.out.println("asd");
			return as.getAllAddresses();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@PutMapping(value = "/address/{id}", consumes = "application/json")
	public Address updateAddress(@PathVariable("id") int id, @RequestBody Address a) {
		// TODO Auto-generated method stub
		try {
			a.setAdd_Id(id);
			return as.updateAddress(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@DeleteMapping(value = "/address/{id}")
	public boolean deleteAddress(@PathVariable("id") int id) {
		// TODO Auto-generated method stub
		try {
			return as.deleteAddress(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@GetMapping(value = "/getAddressByCountry/{country}", produces = "application/json")
	public List<Address> getAddressByCountry(@PathVariable("country") String country) {
		// TODO Auto-generated method stub
		try {
			return as.getAddressByCountry(country);
		} catch(Exception e) {
			System.out.println("Error in controller layer: " + e.getMessage());
			return null;
		}
	}

}
