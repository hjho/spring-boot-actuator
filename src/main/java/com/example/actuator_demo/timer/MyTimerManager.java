package com.example.actuator_demo.timer;

import org.springframework.stereotype.Service;

@Service
public class MyTimerManager {

    public long getCount() {
        return System.currentTimeMillis();

    }

    public long getTotalTime() {
        return System.currentTimeMillis() * 2;
    }

    // 펑션 타이머는 max 값을 설정하는 게 없음.
//    public long getMax() {}
}
