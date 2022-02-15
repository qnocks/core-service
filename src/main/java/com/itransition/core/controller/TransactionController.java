package com.itransition.core.controller;

import com.itransition.core.dto.TransactionReplenishDto;
import com.itransition.core.service.TransactionService;
import com.itransition.core.util.AuthorizationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<?> replenishTransaction(@RequestBody TransactionReplenishDto replenishDto,
                                               @RequestHeader HttpHeaders headers) {
        if (AuthorizationUtils.checkAuthorization(headers)) {
            transactionService.replenish(replenishDto);
        }

        return ResponseEntity.ok().build();
    }
}
