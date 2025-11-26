package com.vm.service.claims.repositorysOtherRepo;

import com.vm.service.claims.entitysOtherDB.PdTransactionSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdTransactionSetRepositoryAnother extends JpaRepository<PdTransactionSet,Long> {
}
