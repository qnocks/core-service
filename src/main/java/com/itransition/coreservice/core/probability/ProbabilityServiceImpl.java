package com.itransition.coreservice.core.probability;

import java.util.Random;
import java.util.function.Supplier;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProbabilityServiceImpl implements ProbabilityService {

    @Value("${mock.response.success-probability}")
    private double successProbability;
    private final Random random;

    @SneakyThrows
    @Override
    public Object getWithProbability(Supplier<Object> successSupplier, Supplier<? extends Throwable> failedSupplier) {
        val isSuccess = getRandomBoolean(successProbability);

        if (isSuccess) {
            return successSupplier.get();
        } else {
            throw failedSupplier.get();
        }
    }

    public boolean getRandomBoolean(double probability){
        return random.nextDouble() < probability;
    }
}
