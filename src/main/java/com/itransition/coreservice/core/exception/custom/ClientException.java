package com.itransition.coreservice.core.exception.custom;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class ClientException extends RuntimeException {
}
