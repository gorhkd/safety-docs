package com.paran.safety_docs.domain.document.entity;

import com.paran.safety_docs.domain.work.entity.Work;
import com.paran.safety_docs.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder
@Entity
@Table(name = "documents")
public class Document extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "document_type", nullable = false)
    private DocumentType type;

    @Column(name = "original_name", nullable = false)
    private String originalName;

    @Column(name = "storage_key", nullable = false, unique = true)
    private String storeKey;

    @Column(name = "content_type",  nullable = false)
    private String contentType;

    @Column(name = "file_size",  nullable = false)
    private Long fileSize;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_id", nullable = false)
    private Work work;

    public void assignWork(Work work) {
        this.work = work;
    }
}
