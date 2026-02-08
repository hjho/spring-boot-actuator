package com.example.actuator_demo.custommetrics;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyStockMeterBinderConfig {

    @Bean
    public MeterBinder myMeterBinder(MyStockManager myStockManager) {
        return new MeterBinder() {
            @Override
            public void bindTo(MeterRegistry registry) {
                // 1. 특정함수를 지정하는 함수.
//                Gauge.builder("my.stock", myStockManager, m -> {
//                    return m.getStockCount();
//                })
//                .register(registry);

                // 2. Supplier 를 이용한 방식.
                Gauge.builder("my.stock", myStockManager).register(registry);
            }
        };
    }
}
