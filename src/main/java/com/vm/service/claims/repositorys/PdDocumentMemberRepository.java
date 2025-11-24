package com.vm.service.claims.repositorys;

import com.vm.service.claims.entitys.PdDocumentMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdDocumentMemberRepository extends JpaRepository<PdDocumentMember,Long> {
}
