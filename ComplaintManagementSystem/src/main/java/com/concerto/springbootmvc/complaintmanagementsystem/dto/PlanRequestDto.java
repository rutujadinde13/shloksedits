package com.concerto.springbootmvc.complaintmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PlanRequestDto {
	private String planName;
	private String planProvider;
	private String planDuration;
}
