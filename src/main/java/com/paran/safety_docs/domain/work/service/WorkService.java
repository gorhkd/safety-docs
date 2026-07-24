package com.paran.safety_docs.domain.work.service;

import com.paran.safety_docs.domain.document.entity.Document;
import com.paran.safety_docs.domain.document.entity.DocumentType;
import com.paran.safety_docs.domain.document.service.DocumentStorageService;
import com.paran.safety_docs.domain.work.dto.request.WorkCreateRequest;
import com.paran.safety_docs.domain.work.entity.Work;
import com.paran.safety_docs.domain.work.repository.WorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class WorkService {

    private final WorkRepository workRepository;
    private final DocumentStorageService documentStorageService;

    @Transactional
    public Long create(WorkCreateRequest request) {

        Work work = Work.builder()
                .title(request.getTitle().trim())
                .description(request.getDescription().trim())
                .build();

        Document sopDocument = documentStorageService.store(
                request.getSopFile(),
                DocumentType.SOP
        );

//        Document riskDocument = documentStorageService.store(
//                request.getRiskFile(),
//                DocumentType.RISK
//        );
//
//        work.addDocument(sopDocument);
//        work.addDocument(riskDocument);

        return workRepository.save(work).getId();
        }
    }
