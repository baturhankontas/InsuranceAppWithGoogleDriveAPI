package com.accenture.insurance.services;

import java.util.List;

import com.accenture.insurance.beans.Customer;

public interface CustomerService {
	
	public Customer getCustomer(int id);
	public Customer getCustomerByAddress(int add_id);
	public List<Customer> getAllCustomers();
	public Customer createCustomer(Customer a);
	public Customer updateCustomer(Customer a);
	public boolean deleteCustomer(int id);
}
