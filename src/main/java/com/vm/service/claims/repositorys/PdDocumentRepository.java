package com.vm.service.claims.repositorys;

import com.vm.service.claims.entitys.PdDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdDocumentRepository extends JpaRepository<PdDocument,Long> {
}
