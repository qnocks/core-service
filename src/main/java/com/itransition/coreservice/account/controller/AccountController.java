package com.itransition.coreservice.account.controller;

import com.itransition.coreservice.account.dto.AccountDto;
import com.itransition.coreservice.account.service.AccountService;
import com.itransition.coreservice.core.util.AuthorizationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{account_id}")
    public ResponseEntity<AccountDto> checkExistingAccount(@PathVariable("account_id") String accountId,
                                                           @RequestHeader HttpHeaders headers) {
        if (AuthorizationUtils.checkAuthorization(headers)) {
            // TODO: implement 'smart' mocking response when external payment service is over
            //  meanwhile comment out either success or failed response
            return ResponseEntity.ok(accountService.checkExistingAccount(accountId));
        }

        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
