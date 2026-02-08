package com.example.actuator_demo.counter;

import io.micrometer.core.annotation.Counted;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter")
@RequiredArgsConstructor
public class CounterController {

    private final MyHttpRequestManager myHttpRequestManager;


    private final MyHttpRequestManagerWithoutMicrometer myHttpRequestManagerWithoutMicrometer;

    @Counted("my.counted.counter")
    @GetMapping("/req")
    public String req() {
        // 1. 카운터 실습.
        myHttpRequestManager.increase();

        // 2. 펑션 카운터 실습.
        myHttpRequestManagerWithoutMicrometer.increase();

        // 3. @Aspect @Counted 카운터 실습.
        // @Counted("my.counted.counter")
        return "ok";
    }
}
