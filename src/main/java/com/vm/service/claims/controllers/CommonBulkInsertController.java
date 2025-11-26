package com.vm.service.claims.controllers;


import com.vm.service.claims.entitys.*;
import com.vm.service.claims.service.CommonBulkInsertServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CommonBulkInsertController {

    private final CommonBulkInsertServiceImp service;

    @PostMapping("/pd-product")
    public ResponseEntity<String> savePdProduct(@RequestBody List<PdProduct> docs) {
        service.savePdProduct(docs);
        return ResponseEntity.ok("PdProduct saved");
    }


    @PostMapping("/pd-documents")
    public ResponseEntity<String> savePdDocuments(@RequestBody List<PdDocument> docs) {
        service.savePdDocuments(docs);
        return ResponseEntity.ok("PdDocuments saved");
    }

    @PostMapping("/pd-document-versions")
    public ResponseEntity<String> savePdDocumentVersions(@RequestBody List<PdDocumentVersion> versions) {
        service.savePdDocumentVersions(versions);
        return ResponseEntity.ok("PdDocumentVersions saved");
    }

    @PostMapping("/pd-document-members")
    public ResponseEntity<String> savePdDocumentMembers(@RequestBody List<PdDocumentMember> members) {
        service.savePdDocumentMembers(members);
        return ResponseEntity.ok("PdDocumentMembers saved");
    }

    @PostMapping("/pd-filings")
    public ResponseEntity<String> savePdFilings(@RequestBody List<PdFiling> filings) {
        service.savePdFilings(filings);
        return ResponseEntity.ok("PdFilings saved");
    }

    @PostMapping("/pd-transaction-sets")
    public ResponseEntity<String> savePdTransactionSets(@RequestBody List<PdTransactionSet> sets) {
        service.savePdTransactionSets(sets);
        return ResponseEntity.ok("PdTransactionSets saved");
    }

    @PostMapping("/pd-transaction-set-values")
    public ResponseEntity<String> savePdTransactionSetValues(@RequestBody List<PdTransactionSetValue> values) {
        service.savePdTransactionSetValues(values);
        return ResponseEntity.ok("PdTransactionSetValues saved");
    }

    @PostMapping("/jurisdiction-sets")
    public ResponseEntity<String> saveJurisdictionSets(@RequestBody List<JurisdictionSet> sets) {
        service.saveJurisdictionSets(sets);
        return ResponseEntity.ok("JurisdictionSets saved");
    }

    @PostMapping("/jurisdiction-set-values")
    public ResponseEntity<String> saveJurisdictionSetValues(@RequestBody List<JurisdictionSetValues> values) {
        service.saveJurisdictionSetValues(values);
        return ResponseEntity.ok("JurisdictionSetValues saved");
    }
}
