package com.vm.service.claims.repositorysOtherRepo;

import com.vm.service.claims.entitysOtherDB.PdDocumentMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdDocumentMemberRepositoryAnother extends JpaRepository<PdDocumentMember,Long> {
}
