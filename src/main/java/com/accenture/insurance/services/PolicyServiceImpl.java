package com.accenture.insurance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.insurance.beans.Policy;
import com.accenture.insurance.repos.PolicyRepo;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	PolicyRepo pr;
	
	@Override
	public Policy getPolicyById(int id) {
		// TODO Auto-generated method stub
		try {
			return pr.findById(id).get();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Policy> getAllPolicies() {
		// TODO Auto-generated method stub
		try {
			return (List<Policy>)pr.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Policy> getAllPoliciesByType(int type) {
		// TODO Auto-generated method stub
		try {
			return pr.findPoliciesByType(type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Policy> getAllPoliciesByUserId(int cust_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Policy createPolicy(Policy p) {
		// TODO Auto-generated method stub
		try {
			return pr.save(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Policy updatePolicy(Policy p) {
		// TODO Auto-generated method stub
		try {
			return pr.save(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deletePolicy(int id) {
		// TODO Auto-generated method stub
		try {
			pr.delete(pr.findById(id).get());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
