package com.paran.safety_docs.global.config.security;

import com.paran.safety_docs.domain.auth.entity.AdminAccount;
import com.paran.safety_docs.domain.auth.repository.AdminAccountRepository;
import com.paran.safety_docs.global.exception.CustomException;
import com.paran.safety_docs.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminAccountDetailsService implements UserDetailsService {

    private final AdminAccountRepository adminAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        AdminAccount account = adminAccountRepository.findByUsername(username)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        return User.withUsername(account.getUsername())
                .password(account.getPassword())
                .roles("ADMIN")
                .build();
    }
}
