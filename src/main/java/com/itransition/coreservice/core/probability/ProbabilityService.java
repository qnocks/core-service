package com.itransition.coreservice.core.probability;

import java.util.function.Supplier;

public interface ProbabilityService {

    Object getWithProbability(Supplier<Object> successSupplier, Supplier<? extends Throwable> failedSupplier);
}
