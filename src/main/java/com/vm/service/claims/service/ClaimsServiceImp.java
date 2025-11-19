package com.vm.service.claims.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vm.service.claims.dtos.ClaimsDto;
import com.vm.service.claims.entitys.Claims;
import com.vm.service.claims.repo.ClaimsRepository;

@Service
public class ClaimsServiceImp {
	
	@Autowired
	private ClaimsRepository claimsRepository;
	
	@Autowired
	private ModelMapper mapper;

	public List<ClaimsDto> fetchAllClaims() {
		// TODO Auto-generated method stub
		List<Claims> claims = claimsRepository.findAll();
		
		List<ClaimsDto> listOfClaims=new ArrayList<ClaimsDto>();
		for(Claims claim:claims) {
			ClaimsDto map = mapper.map(claim, ClaimsDto.class);
			listOfClaims.add(map);
		}
		return listOfClaims;
	}

}
