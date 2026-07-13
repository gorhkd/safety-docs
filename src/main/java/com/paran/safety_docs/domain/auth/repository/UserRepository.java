package com.paran.safety_docs.domain.auth.repository;

import com.paran.safety_docs.domain.auth.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
