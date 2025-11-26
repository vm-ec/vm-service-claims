package com.vm.service.claims.repositorysOtherRepo;

import com.vm.service.claims.entitysOtherDB.JurisdictionSetValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JurisdictionSetValuesRepositoryAnother extends JpaRepository<JurisdictionSetValues,Long> {
}
