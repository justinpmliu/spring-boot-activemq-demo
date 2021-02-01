package com.example.springboot.activemq.demo.controller;

import com.example.springboot.activemq.demo.jms.Producer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    private Producer producer;

    public ProducerController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping("/queue/demo")
    public ResponseEntity<String> sendQueue(@RequestBody String msg) {
        producer.sendMessage(msg);
        return ResponseEntity.ok("success");
    }

}
