package com.itransition.core.account.service.impl;

import com.itransition.core.account.dto.AccountDto;
import com.itransition.core.account.service.AccountService;
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
