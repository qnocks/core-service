package com.itransition.core.account.service;

import com.itransition.core.account.dto.AccountDto;

public interface AccountService {

    AccountDto checkExistingAccount(String accountId);
}
