package com.vm.service.claims.repositorysOtherRepo;

import com.vm.service.claims.entitysOtherDB.PdDocumentVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdDocumentVersionRepositoryAnother extends JpaRepository<PdDocumentVersion,Long> {
}
