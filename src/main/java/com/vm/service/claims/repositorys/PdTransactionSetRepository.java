package com.vm.service.claims.repositorys;

import com.vm.service.claims.entitys.PdTransactionSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdTransactionSetRepository extends JpaRepository<PdTransactionSet,Long> {
}
