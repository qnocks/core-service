package com.itransition.core.transaction.service;

import com.itransition.core.transaction.dto.TransactionReplenishDto;

public interface TransactionService {

    void replenish(TransactionReplenishDto replenishDto);
}
