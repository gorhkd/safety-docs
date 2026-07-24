package com.paran.safety_docs.domain.auth.repository;

import com.paran.safety_docs.domain.auth.entity.AdminAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminAccountRepository extends CrudRepository<AdminAccount, Long> {
    Optional<AdminAccount> findByUsername(String username);
}
