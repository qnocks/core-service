package com.itransition.core.account.service.impl;

import com.itransition.core.account.dto.AccountDto;
import com.itransition.core.account.service.AccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final Logger log = LogManager.getLogger(AccountServiceImpl.class);

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
