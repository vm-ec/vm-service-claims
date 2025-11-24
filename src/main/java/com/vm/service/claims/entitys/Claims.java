package com.vm.service.claims.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
public class Claims {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long claimId;
	private String claimType;
	private String claimStatus;
	private String description;
	

	

}
