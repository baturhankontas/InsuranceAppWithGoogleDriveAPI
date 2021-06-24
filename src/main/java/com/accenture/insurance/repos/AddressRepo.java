package com.accenture.insurance.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.insurance.beans.Address;


@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

	public List<Address> findByCountry(String Country);
}
