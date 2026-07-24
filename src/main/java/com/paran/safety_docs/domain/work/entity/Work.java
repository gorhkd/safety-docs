package com.paran.safety_docs.domain.work.entity;

import com.paran.safety_docs.domain.document.entity.Document;
import com.paran.safety_docs.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@SuperBuilder
@Entity
@Table(name = "works")
public class Work extends BaseEntity {

    @Column(nullable = false, unique = true, length = 100)
    private String title;

    @Column(nullable = false, length = 1000)
    private String description;

    @Builder.Default
    @OneToMany(mappedBy = "work", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documents = new ArrayList<>();

    public void addDocument(Document document) {
        documents.add(document);
        document.assignWork(this);
    }
}
