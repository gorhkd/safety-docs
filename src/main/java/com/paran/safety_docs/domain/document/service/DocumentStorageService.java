package com.paran.safety_docs.domain.document.service;

import com.paran.safety_docs.domain.document.entity.Document;
import com.paran.safety_docs.domain.document.entity.DocumentType;
import com.paran.safety_docs.domain.document.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class DocumentStorageService {

    private final DocumentRepository documentRepository;

    public Document store(MultipartFile sopFile, DocumentType documentType) {
    return null;
    }
}
