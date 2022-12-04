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

public class ComplaintPlanDto {
	private String planName;
	private String planProvider;
	private String planDuration;
	private String complaintDescription;

}
