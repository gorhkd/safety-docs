package com.paran.safety_docs.domain.work.repository;

import com.paran.safety_docs.domain.work.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {
}
