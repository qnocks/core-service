package com.itransition.core.service.impl;

import com.itransition.core.dto.TransactionReplenishDto;
import com.itransition.core.service.TransactionService;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public void replenish(TransactionReplenishDto replenishDto) {
        // mocking replenishment process
    }
}
