package com.vm.service.claims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vm.service.claims.dtos.ClaimsDto;
import com.vm.service.claims.service.ClaimsServiceImp;

@RestController
@RequestMapping("/claims")
public class ClaimsController {
	
	@Autowired
	private ClaimsServiceImp claimsServiceImp;
	
	 @GetMapping("/fetch")
	 public ResponseEntity<List<ClaimsDto> >fetchAllClaims() {
		 List<ClaimsDto> fetchAllClaims = claimsServiceImp.fetchAllClaims();
	        return ResponseEntity.status(HttpStatus.OK).body(fetchAllClaims);
	    }
	

}
