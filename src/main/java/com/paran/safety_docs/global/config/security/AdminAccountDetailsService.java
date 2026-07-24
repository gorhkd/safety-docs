package com.paran.safety_docs.global.config.security;

import com.paran.safety_docs.domain.auth.entity.AdminAccount;
import com.paran.safety_docs.domain.auth.repository.AdminAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminAccountDetailsService implements UserDetailsService {

    private final AdminAccountRepository adminAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        AdminAccount account = adminAccountRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("아이디 또는 비밀번호가 올바르지 않습니다."));

        return User.withUsername(account.getUsername())
                .password(account.getPassword())
                .roles("ADMIN")
                .build();
    }
}
