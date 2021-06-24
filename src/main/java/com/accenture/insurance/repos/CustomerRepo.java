package com.accenture.insurance.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.insurance.beans.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>  {

	public Customer findByAddress(int add_id);
	
	

}
