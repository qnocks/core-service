package com.itransition.coreservice.transaction.service.impl;

import com.itransition.coreservice.core.exception.custom.ServerException;
import com.itransition.coreservice.core.probability.ProbabilityService;
import com.itransition.coreservice.transaction.dto.TransactionReplenishDto;
import com.itransition.coreservice.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final Logger log = LogManager.getLogger(TransactionServiceImpl.class);
    private final ProbabilityService probabilityService;

    @Override
    public void replenish(TransactionReplenishDto replenishDto) {
        probabilityService.getWithProbability(
                () -> {
                    // mocking replenishment process
                    log.info("IN replenish - replenishment process");
                    return null;
                }, () -> {
                    log.info("IN replenish - ERROR OCCURRED");
                    throw ServerException.builder().build();
                }
        );
    }
}
