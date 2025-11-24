package com.vm.service.claims.repositorys;

import com.vm.service.claims.entitys.PdFiling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdFilingRepository extends JpaRepository<PdFiling,Long> {
}
