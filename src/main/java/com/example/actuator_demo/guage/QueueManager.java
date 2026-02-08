package com.example.actuator_demo.guage;

import org.springframework.stereotype.Service;

@Service
public class QueueManager {

    public long getQueueSize() {
        // 실제로는 현재 쌓여있는 Queue 사이즈를 조회.
        return System.currentTimeMillis();
    }
}
