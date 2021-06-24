package com.accenture.insurance.controllers;

import java.util.List;

import com.accenture.insurance.beans.Customer;

public interface CustomerController {

	public Customer getCustomer(int id);
	public List<Customer> getAllCustomers();
	public Customer createCustomer(Customer a);
	public Customer updateCustomer(int id, Customer c);
	public boolean deleteCustomer(int id);
	public Customer getCustomerByAddress(int add_id);
}
