package com.example.actuator_demo.guage;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GaugeConfigWithMeterBinder {

    @Bean
    public MeterBinder gaugeMeterBinder(QueueManager queueManager) {
        MeterBinder meterBinder = new MeterBinder() {
            @Override
            public void bindTo(MeterRegistry meterRegistry) {
                Gauge.builder("my.queue2.size", queueManager, queueManager -> {
                    return queueManager.getQueueSize();
                }).register(meterRegistry);
            }
        };
        return meterBinder;
    }
}
