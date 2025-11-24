package com.vm.service.claims.controllers;

import com.vm.service.claims.dtos.PdDocumentDto;
import com.vm.service.claims.service.PdDocumentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/document")
public class PdDocumentController {

    private final PdDocumentServiceImpl pdDocumentService;

    @PostMapping("/create")
    public ResponseEntity<PdDocumentDto> create(@RequestBody PdDocumentDto dto) {
        return ResponseEntity.ok(pdDocumentService.saveDocument(dto));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<PdDocumentDto>> getAll() {
        return ResponseEntity.ok(pdDocumentService.getAllDocuments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PdDocumentDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(pdDocumentService.getDocumentById(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<PdDocumentDto> update(@PathVariable Long id ,@RequestBody PdDocumentDto dto) {
        return ResponseEntity.ok(pdDocumentService.saveDocument(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        pdDocumentService.deleteDocument(id);
        return ResponseEntity.ok("Document deleted successfully");
    }
}
