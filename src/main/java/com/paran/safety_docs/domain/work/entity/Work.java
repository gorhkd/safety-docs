package com.paran.safety_docs.domain.work.entity;

import com.paran.safety_docs.global.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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

}
