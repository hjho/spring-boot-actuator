package com.example.actuator_demo.counter;

import io.micrometer.core.instrument.FunctionCounter;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CounterConfigWithMeterBinder {

    @Bean
    public MeterBinder myCounterWithMeterBinder(MyHttpRequestManagerWithoutMicrometer myManager) {
        // new MeterBinder 를 람다식으로 변경한 형태.
        return meterRegistry -> FunctionCounter.builder("my.function.counter2", myManager, MyHttpRequestManagerWithoutMicrometer::getCount).register(meterRegistry);
    }
}
