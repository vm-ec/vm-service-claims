package com.vm.service.claims.repositorys;

import com.vm.service.claims.entitys.PdDocumentVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdDocumentVersionRepository extends JpaRepository<PdDocumentVersion,Long> {
}
