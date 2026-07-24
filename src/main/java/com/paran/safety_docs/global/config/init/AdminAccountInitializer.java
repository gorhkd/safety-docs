package com.paran.safety_docs.global.config.init;

import com.paran.safety_docs.domain.auth.entity.ActiveStatus;
import com.paran.safety_docs.domain.auth.entity.AdminAccount;
import com.paran.safety_docs.domain.auth.repository.AdminAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
@RequiredArgsConstructor
public class AdminAccountInitializer implements ApplicationRunner {

    private final AdminAccountRepository adminAccountRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.admin.username}")
    private String username;

    @Value("${app.admin.password}")
    private String rawPassword;

    @Override
    public void run(ApplicationArguments args) {
        if (adminAccountRepository.findByUsername(username).isPresent()) {
            return;
        }

        AdminAccount account = AdminAccount.builder()
                .username(username)
                .password(passwordEncoder.encode(rawPassword))
                .status(ActiveStatus.ACTIVE)
                .build();

        adminAccountRepository.save(account);
    }
}