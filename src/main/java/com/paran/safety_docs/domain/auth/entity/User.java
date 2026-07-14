package com.paran.safety_docs.domain.auth.entity;

import com.paran.safety_docs.global.common.entity.BaseCreatedOnlyEntity;
import com.paran.safety_docs.global.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name = "users")
@Entity
public class User extends BaseEntity {

    private String username;

    private String password;

    private ActiveStatus is_active;
}
