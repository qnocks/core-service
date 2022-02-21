package com.itransition.core.transaction.controller;

import com.itransition.core.transaction.dto.TransactionReplenishDto;
import com.itransition.core.transaction.service.TransactionService;
import com.itransition.core.authorization.util.AuthorizationUtils;
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

        // TODO: implement 'smart' mocking response when external payment service is over
        //  meanwhile comment out either success or failed response
//        return ResponseEntity.internalServerError().build();
        return ResponseEntity.ok().build();
    }
}
