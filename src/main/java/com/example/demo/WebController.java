package com.example.demo;

import io.opencensus.trace.SpanBuilder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
@Slf4j
public class WebController {

    @GetMapping("/service2")
    @SneakyThrows
    public ResponseEntity<String> postMsg(){
        log.info("came to service2");
        Thread.sleep(1800);
        log.info("going back from service2");
        return ResponseEntity.ok("From service2");
    }
}
