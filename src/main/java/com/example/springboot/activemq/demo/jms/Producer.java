package com.example.springboot.activemq.demo.jms;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.Queue;

@Component
public class Producer {
    private JmsTemplate jmsTemplate;
    private Queue queue;

    public Producer(JmsTemplate jmsTemplate, @Value("${spring.activemq.queue-name}") String queueName) {
        this.jmsTemplate = jmsTemplate;
        this.queue = new ActiveMQQueue(queueName);
    }

    public void sendMessage(final String msg) {
        this.sendMessage(queue, msg);
    }

    private void sendMessage(Destination dest, final String msg) {
        jmsTemplate.convertAndSend(dest, msg);
    }
}
