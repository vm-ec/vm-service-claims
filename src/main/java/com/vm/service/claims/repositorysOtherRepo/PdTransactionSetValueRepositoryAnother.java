package com.vm.service.claims.repositorysOtherRepo;

import com.vm.service.claims.entitysOtherDB.PdTransactionSetValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdTransactionSetValueRepositoryAnother extends JpaRepository<PdTransactionSetValue,Long> {
}
