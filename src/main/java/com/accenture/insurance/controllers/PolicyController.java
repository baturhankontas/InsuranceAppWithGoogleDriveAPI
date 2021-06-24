package com.accenture.insurance.controllers;

import java.util.List;

import com.accenture.insurance.beans.Policy;

public interface PolicyController {

	public Policy createPolicy(Policy p);
	public Policy getPolicy(int id);
	public List<Policy> getAllPolicy();
	public Policy updatePolicy(int id, Policy p);
	public boolean deletePolicy(int id);
	public List<Policy> getAllPoliciesByType(int type);
	public List<Policy> getAllPoliciesByUserId(int cust_id);
}
