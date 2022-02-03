package com.itransition.core.service;

import com.itransition.core.dto.AccountDto;

public interface AccountService {

    AccountDto checkExistingAccount(String accountId);
}
