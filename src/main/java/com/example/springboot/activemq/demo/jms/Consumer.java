package com.example.springboot.activemq.demo.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

@Component
@Slf4j
public class Consumer {

    @JmsListener(
            destination = "${spring.activemq.queue-name}",
            containerFactory = "jmsQueueListener",
            concurrency = "2-10")
    public void receive(final TextMessage msg, Session session) {
        try {
            log.info("received message: {}", msg.getText());
            if ("msg-2".equals(msg.getText())) {
                throw new RuntimeException("Threw exception");
            }
            msg.acknowledge();
            Thread.sleep(500);
        } catch (Exception e) {
            try {
                session.recover();
            } catch (JMSException ex) {
                log.error("Failed to recover message");
            }
        }
    }
}
