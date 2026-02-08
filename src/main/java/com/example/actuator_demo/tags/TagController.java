package com.example.actuator_demo.tags;

import io.micrometer.core.annotation.Counted;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tag")
@RequiredArgsConstructor
@Slf4j
public class TagController {

    private final MyQueueManagerWithTags myQueueManagerWithTags;

    @Counted(value = "my.queue.counted", extraTags = {"type", "value1", "type2", "value2"})
    @GetMapping("/push")
    public String push() {
        myQueueManagerWithTags.push();
        return "push";
    }

    @Counted(value = "my.queue.counted", extraTags = {"type", "value3", "type5", "value5"})
    @GetMapping("/pop")
    public String pop() {
        myQueueManagerWithTags.pop();
        return "pop";
    }
}
