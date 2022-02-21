package com.itransition.core.transaction.service.impl;

import com.itransition.core.transaction.dto.TransactionReplenishDto;
import com.itransition.core.transaction.service.TransactionService;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public void replenish(TransactionReplenishDto replenishDto) {
        // mocking replenishment process
    }
}
