package com.accenture.insurance.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.insurance.beans.Policy;

@Repository
public interface PolicyRepo extends JpaRepository<Policy, Integer> {

	public List<Policy> findPoliciesByType(int type);
}
