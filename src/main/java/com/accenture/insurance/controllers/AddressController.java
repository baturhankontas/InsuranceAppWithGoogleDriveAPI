package com.accenture.insurance.controllers;

import java.util.List;


import com.accenture.insurance.beans.Address;

public interface AddressController {

	public Address createAddress(Address a);
	public Address getAddress(int id);
	public List<Address> getAllAddresses();
	public Address updateAddress(int id, Address a);
	public boolean deleteAddress(int id);
	public List<Address> getAddressByCountry(String country);
}
