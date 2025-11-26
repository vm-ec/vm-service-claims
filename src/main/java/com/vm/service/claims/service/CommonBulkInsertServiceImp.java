package com.vm.service.claims.service;

import com.vm.service.claims.entitys.*;
import com.vm.service.claims.repositorys.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CommonBulkInsertServiceImp {

    private final PdDocumentRepository pdDocumentRepo;
    private final PdDocumentVersionRepository pdDocumentVersionRepo;
    private final PdDocumentMemberRepository pdDocumentMemberRepo;
    private final PdFilingRepository pdFilingRepo;
    private final PdTransactionSetRepository pdTransactionSetRepo;
    private final PdTransactionSetValueRepository pdTransactionSetValueRepo;
    private final JurisdictionSetRepository jurisdictionSetRepo;
    private final JurisdictionSetValuesRepository jurisdictionSetValuesRepo;
    private final PdProductRepository pdProductRepo;

    @Transactional("h2TransactionManager")
    public void savePdDocuments(List<PdDocument> docs) {
        pdDocumentRepo.saveAll(docs);
    }

    @Transactional("h2TransactionManager")
    public void savePdDocumentVersions(List<PdDocumentVersion> versions) {
        pdDocumentVersionRepo.saveAll(versions);
    }

    @Transactional("h2TransactionManager")
    public void savePdDocumentMembers(List<PdDocumentMember> members) {
        pdDocumentMemberRepo.saveAll(members);
    }

    @Transactional("h2TransactionManager")
    public void savePdFilings(List<PdFiling> filings) {
        pdFilingRepo.saveAll(filings);
    }

    @Transactional("h2TransactionManager")
    public void savePdTransactionSets(List<PdTransactionSet> sets) {
        pdTransactionSetRepo.saveAll(sets);
    }

    @Transactional("h2TransactionManager")
    public void savePdTransactionSetValues(List<PdTransactionSetValue> values) {
        pdTransactionSetValueRepo.saveAll(values);
    }

    @Transactional("h2TransactionManager")
    public void saveJurisdictionSets(List<JurisdictionSet> sets) {
        jurisdictionSetRepo.saveAll(sets);
    }

    @Transactional("h2TransactionManager")
    public void saveJurisdictionSetValues(List<JurisdictionSetValues> values) {

        jurisdictionSetValuesRepo.saveAll(values);
    }

    public void savePdProduct(List<PdProduct> docs) {
        pdProductRepo.saveAll(docs);
    }
}
