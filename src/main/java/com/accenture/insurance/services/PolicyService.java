package com.accenture.insurance.services;

import java.util.List;

import com.accenture.insurance.beans.Policy;

public interface PolicyService {

	public Policy getPolicyById(int id);
	public List<Policy> getAllPolicies();
	public List<Policy> getAllPoliciesByType(int type);
	public List<Policy> getAllPoliciesByUserId(int cust_id);
	public Policy createPolicy(Policy p);
	public Policy updatePolicy(Policy p);
	public boolean deletePolicy(int id);
}
