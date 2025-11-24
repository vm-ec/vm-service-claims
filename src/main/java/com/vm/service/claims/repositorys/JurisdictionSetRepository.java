package com.vm.service.claims.repositorys;

import com.vm.service.claims.entitys.JurisdictionSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JurisdictionSetRepository extends JpaRepository<JurisdictionSet,Long> {
}
