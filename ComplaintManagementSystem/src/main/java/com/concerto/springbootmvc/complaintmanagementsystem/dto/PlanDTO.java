package com.concerto.springbootmvc.complaintmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlanDTO {

	private int planId;

	private String planName;
	private String planProvider;
	private String planDescription;
	private String planDuration;
	private double planAmount;
}
