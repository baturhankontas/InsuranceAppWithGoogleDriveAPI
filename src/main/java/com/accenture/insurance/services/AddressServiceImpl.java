package com.accenture.insurance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.insurance.beans.Address;
import com.accenture.insurance.repos.AddressRepo;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepo ar;
	
	
	@Override
	public Address getAddress(int id) {
		// TODO Auto-generated method stub
		try {
			return ar.findById(id).get();
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Address> getAllAddresses() {
		// TODO Auto-generated method stub
		try {
			return (List<Address>)ar.findAll();
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Address> getAddressByCountry(String country) {
		// TODO Auto-generated method stub
		try {
			List<Address> addresses = ar.findByCountry(country);
			if(addresses.isEmpty()) {
				return null;
			}
			else {
				return addresses;
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Address createAddress(Address a) {
		// TODO Auto-generated method stub
		try {
			return ar.save(a);
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Address updateAddress(Address a) {
		// TODO Auto-generated method stub
		try {
			return ar.save(a);
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteAddress(int id) {
		// TODO Auto-generated method stub
		try {
			ar.delete(ar.findById(id).get());
			return true;
		} catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

}
