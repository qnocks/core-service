package com.itransition.core.controller;

import com.itransition.core.dto.AccountDto;
import com.itransition.core.service.AccountService;
import com.itransition.core.util.AuthorizationUtils;
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
            return ResponseEntity.ok(accountService.checkExistingAccount(accountId));
        }

        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
