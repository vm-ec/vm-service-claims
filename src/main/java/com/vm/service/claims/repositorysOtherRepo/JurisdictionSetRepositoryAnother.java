package com.vm.service.claims.repositorysOtherRepo;

import com.vm.service.claims.entitysOtherDB.JurisdictionSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JurisdictionSetRepositoryAnother extends JpaRepository<JurisdictionSet,Long> {
}
