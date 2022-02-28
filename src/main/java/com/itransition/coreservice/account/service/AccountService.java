package com.itransition.coreservice.account.service;

import com.itransition.coreservice.account.dto.AccountDto;

public interface AccountService {

    AccountDto checkExistingAccount(String accountId);
}
