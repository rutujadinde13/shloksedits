package com.concerto.springbootmvc.complaintmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concerto.springbootmvc.complaintmanagementsystem.entity.Plan;
import com.concerto.springbootmvc.complaintmanagementsystem.repository.PlanRepository;

//plan service
@Service
public class PlanService {

	@Autowired
	private PlanRepository planRepository;

	// get data based on planName, planProvider, planDuration
	public Plan getPlanByDetails(String planName, String planProvider, String planDuration) {
			
		return this.planRepository.findByPlanNameContainsAndPlanProviderContainsAndPlanDurationContains(planName,
				planProvider, planDuration);
	}

	// get all plan names
	public List<String> getAllPlansName() {
		return this.planRepository.findPlanNames();
	}

	// get all plan providers based on plan name
	public List<String> getAllProviderByPlanName(String planName) {
		return this.planRepository.findPlanProvidersByPlanName(planName);
	}

	// get all plan description based on plan providers
	public List<String> getAllDescriptionByPlanProvider(String planProvider) {
		return this.planRepository.findPlanDescriptionByPlanProvider(planProvider);
	}

	// get all plan Duration based on plan description
	public List<String> getAllDurationByPlanDescription(String planDescription) {
		return this.planRepository.findPlanDurationByPlanDescription(planDescription);
	}

	// get all plan Amount based on plan Duration
	public List<String> getAllAmountByPlanDuration(String planDuration) {
		return this.planRepository.findPlanAmountByPlanDuration(planDuration);
	}

}
