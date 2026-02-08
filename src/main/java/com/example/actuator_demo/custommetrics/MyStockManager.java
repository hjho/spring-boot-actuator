package com.example.actuator_demo.custommetrics;

import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class MyStockManager implements Supplier<Number> {

    public long getStockCount() {
        // 실제 재고수량 DB조회.
        return System.currentTimeMillis();
    }

    @Override
    public Number get() {
        return this.getStockCount();
    }
}
