package com.itransition.core.transaction.service.impl;

import com.itransition.core.transaction.dto.TransactionReplenishDto;
import com.itransition.core.transaction.service.TransactionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final Logger log = LogManager.getLogger(TransactionServiceImpl.class);

    @Override
    public void replenish(TransactionReplenishDto replenishDto) {
        // mocking replenishment process
        log.info("IN replenish - replenishment process");
    }
}
