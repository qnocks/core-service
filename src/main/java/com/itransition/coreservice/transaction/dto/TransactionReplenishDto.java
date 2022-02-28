package com.itransition.coreservice.transaction.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionReplenishDto {

    private String provider;
    private String outerId;
    private String gateId;
    private Integer account;
    private BigDecimal amount;
    private BigDecimal commissionAmount;
    private String orderId;
}
