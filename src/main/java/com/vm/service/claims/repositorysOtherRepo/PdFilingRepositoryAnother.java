package com.vm.service.claims.repositorysOtherRepo;

import com.vm.service.claims.entitysOtherDB.PdFiling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdFilingRepositoryAnother extends JpaRepository<PdFiling,Long> {
}
