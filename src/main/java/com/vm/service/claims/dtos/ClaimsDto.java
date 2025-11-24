package com.vm.service.claims.dtos;

import lombok.Data;

@Data
public class ClaimsDto {
	
	private Long claimId;
	private String claimType;
	private String claimStatus;
	private String description;

	
}
