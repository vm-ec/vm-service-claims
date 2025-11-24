package com.vm.service.claims.repositorys;

import com.vm.service.claims.entitys.JurisdictionSetValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JurisdictionSetValuesRepository extends JpaRepository<JurisdictionSetValues,Long> {
}
