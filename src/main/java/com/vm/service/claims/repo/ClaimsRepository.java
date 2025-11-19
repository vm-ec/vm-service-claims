package com.vm.service.claims.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vm.service.claims.entitys.Claims;

@Repository
public interface ClaimsRepository extends JpaRepository<Claims,Long> {

}
