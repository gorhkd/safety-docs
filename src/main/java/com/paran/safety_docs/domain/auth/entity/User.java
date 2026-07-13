package com.paran.safety_docs.domain.auth.entity;

import com.paran.safety_docs.global.common.entity.BaseCreatedOnlyEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name = "users")
@Entity
public class User extends BaseCreatedOnlyEntity {

    private String username;

    private String password;
}
