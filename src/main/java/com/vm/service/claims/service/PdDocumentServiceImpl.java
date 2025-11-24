package com.vm.service.claims.service;

import com.vm.service.claims.dtos.PdDocumentDto;
import com.vm.service.claims.entitys.PdDocument;
import com.vm.service.claims.repositorys.PdDocumentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PdDocumentServiceImpl {

    private final PdDocumentRepository pdDocumentRepository;
    private final ModelMapper mapper;


    public PdDocumentDto saveDocument(PdDocumentDto dto) {
        PdDocument entity = mapper.map(dto, PdDocument.class);
        PdDocument saved = pdDocumentRepository.save(entity);
        return mapper.map(saved, PdDocumentDto.class);
    }


    public List<PdDocumentDto> getAllDocuments() {
        return pdDocumentRepository.findAll()
                .stream()
                .map(doc -> mapper.map(doc, PdDocumentDto.class))
                .collect(Collectors.toList());
    }


    public PdDocumentDto getDocumentById(Long id) {
        PdDocument doc = pdDocumentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found: " + id));
        return mapper.map(doc, PdDocumentDto.class);
    }


    public void deleteDocument(Long id) {
        pdDocumentRepository.deleteById(id);
    }
}
