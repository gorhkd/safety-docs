package com.paran.safety_docs.domain.work.service;

import com.paran.safety_docs.domain.work.repository.WorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class WorkService {

    private final WorkRepository workRepository;
}
