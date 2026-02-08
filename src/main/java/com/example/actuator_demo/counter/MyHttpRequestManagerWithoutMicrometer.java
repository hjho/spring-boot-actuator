package com.example.actuator_demo.counter;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class MyHttpRequestManagerWithoutMicrometer {

    private final AtomicLong count = new AtomicLong(0);

    public long getCount() {
        // AtomicLong 이 아니라 redis 나 db의 값을 가져와도 됨.
        return count.get();
    }

    public void increase() {
        count.incrementAndGet();
    }

}
