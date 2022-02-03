package com.itransition.core.service.impl;

import com.itransition.core.dto.AccountDto;
import com.itransition.core.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public AccountDto checkExistingAccount(String accountId) {
        AccountDto accountDto = AccountDto.builder()
                .firstName("John")
                .lastName("Smith")
                .middleName(null)
                .build();

        log.info("IN checkExistingAccount - returning: {}", accountDto);
        return accountDto;
    }
}
