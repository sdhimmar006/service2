package com.example.demo;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
@Slf4j
public class WebController {

    @Value("${sleep}")
    Integer sleep;

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    @GetMapping("/service2")
    @SneakyThrows
    public ResponseEntity<String> postMsg(){
        log.info("came to service2");
//        Thread.sleep(sleep);
        log.info("going back from service2");
        return ResponseEntity.ok("From service2");
    }

    @GetMapping("/errorEndpoint")
    @SneakyThrows
    public ResponseEntity<String> errorEndpoint(){
        log.error("some random error");
        logger.error("Logging ERROR with Logback");
        return ResponseEntity.ok("From service2 error");
    }
}
