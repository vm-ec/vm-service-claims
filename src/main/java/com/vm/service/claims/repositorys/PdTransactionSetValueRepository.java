package com.vm.service.claims.repositorys;

import com.vm.service.claims.entitys.PdTransactionSetValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdTransactionSetValueRepository extends JpaRepository<PdTransactionSetValue,Long> {
}
