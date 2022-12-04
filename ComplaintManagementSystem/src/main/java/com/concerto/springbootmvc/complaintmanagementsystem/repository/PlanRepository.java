package com.concerto.springbootmvc.complaintmanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.concerto.springbootmvc.complaintmanagementsystem.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

	// find Plan based on plan name,plan provider,plan duration
	public Plan findByPlanNameContainsAndPlanProviderContainsAndPlanDurationContains(String planName,
			String planProvider, String planDuration);

	// find all plan names
	@Query(nativeQuery = true, value = "SELECT DISTINCT planName FROM Plan_Details")
	public List<String> findPlanNames();

	// find all plan providers based on plan name
	@Query(nativeQuery = true, value = "SELECT DISTINCT planProvider FROM Plan_Details Where planName=?")
	public List<String> findPlanProvidersByPlanName(String planName);

	// find all plan description based on plan providers
	@Query(nativeQuery = true, value = "SELECT DISTINCT planDescription FROM Plan_Details Where planProvider=?")
	public List<String> findPlanDescriptionByPlanProvider(String planProvider);

	// find all plan Duration based on plan description
	@Query(nativeQuery = true, value = "SELECT DISTINCT planDuration FROM Plan_Details Where planDescription=?")
	public List<String> findPlanDurationByPlanDescription(String planDescription);

	// find all plan Amount based on plan Duration
	@Query(nativeQuery = true, value = "SELECT DISTINCT planAmount FROM Plan_Details Where planDuration=?")
	public List<String> findPlanAmountByPlanDuration(String planAmount);
}
