package com.accenture.insurance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.insurance.beans.Customer;
import com.accenture.insurance.repos.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo cr;
	
	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		try {
			return cr.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer getCustomerByAddress(int add_id) {
		// TODO Auto-generated method stub
		try {
			return cr.findByAddress(add_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		try {
			return (List<Customer>) cr.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer createCustomer(Customer a) {
		// TODO Auto-generated method stub
		try {
			return cr.save(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer updateCustomer(Customer a) {
		// TODO Auto-generated method stub
		try {
			return cr.save(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteCustomer(int id) {
		// TODO Auto-generated method stub
		try {
			cr.delete(cr.findById(id).get());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
