package com.example.actuator_demo.tags;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyQueueManagerWithTags {

    private final MeterRegistry meterRegistry;

    public void push() {
        Counter.builder("my.queue.counter")
                .tags("type", "push")
                .tags("class", this.getClass().toString())
                .register(meterRegistry).increment();
    }

    public void pop() {
        Counter.builder("my.queue.counter")
                .tags("type", "pop")
                .tags("class", this.getClass().toString())
                .register(meterRegistry).increment();
    }
}
