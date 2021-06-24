package com.accenture.insurance.services;

import java.util.List;

import com.accenture.insurance.beans.Address;

public interface AddressService {

	public Address getAddress(int id);
	public List<Address> getAllAddresses();
	public List<Address> getAddressByCountry(String country);
	public Address createAddress(Address a);
	public Address updateAddress(Address a);
	public boolean deleteAddress(int id);
	
}
