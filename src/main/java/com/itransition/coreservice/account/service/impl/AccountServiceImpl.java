package com.itransition.coreservice.account.service.impl;

import com.itransition.coreservice.account.dto.AccountDto;
import com.itransition.coreservice.account.service.AccountService;
import com.itransition.coreservice.core.exception.custom.ClientException;
import com.itransition.coreservice.core.probability.ProbabilityService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final Logger log = LogManager.getLogger(AccountServiceImpl.class);
    private final ProbabilityService probabilityService;

    @Override
    public AccountDto checkExistingAccount(String accountId) {
        return (AccountDto) probabilityService.getWithProbability(
                () -> {
                    val accountDto = AccountDto.builder()
                            .firstName("John")
                            .lastName("Smith")
                            .middleName(null)
                            .build();
                    log.info("IN checkExistingAccount - returning: {}", accountDto);
                    return accountDto;
                }, () -> {
                    log.info("IN checkExistingAccount - ERROR OCCURRED");
                    throw ClientException.builder().build();
                }
        );
    }
}
