package com.concerto.springbootmvc.complaintmanagementsystem.converter;

import org.springframework.stereotype.Component;

import com.concerto.springbootmvc.complaintmanagementsystem.dto.PlanDTO;
import com.concerto.springbootmvc.complaintmanagementsystem.entity.Plan;

@Component
public class PlanConverter {

	private PlanConverter() {

	}

	public static Plan convertDtoToEntity(PlanDTO planDTO) {
		Plan plan = new Plan();
		plan.setPlanId(planDTO.getPlanId());
		plan.setPlanName(planDTO.getPlanName());
		plan.setPlanProvider(planDTO.getPlanProvider());
		plan.setPlanDescription(planDTO.getPlanDescription());
		plan.setPlanDuration(planDTO.getPlanDuration());
		plan.setPlanAmount(planDTO.getPlanAmount());
		return plan;
	}
}
