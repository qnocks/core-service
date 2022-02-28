package com.itransition.coreservice.transaction.service;

import com.itransition.coreservice.transaction.dto.TransactionReplenishDto;

public interface TransactionService {

    void replenish(TransactionReplenishDto replenishDto);
}
