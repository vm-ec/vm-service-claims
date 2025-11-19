package com.vm.service.claims.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vm.service.claims.entitys.Claims;

public interface ClaimsRepository extends JpaRepository<Claims,Long> {

}
