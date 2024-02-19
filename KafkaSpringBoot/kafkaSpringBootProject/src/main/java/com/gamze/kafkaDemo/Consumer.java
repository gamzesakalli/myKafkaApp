package com.gamze.kafkaDemo;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
@Component
public class Consumer {
    @KafkaListener(topics ="${topic.name}", groupId = "${group.id}")
    public void listenMessage(String message){
        System.out.println("Consumer'den alınan mesaj:"+message);
    }
}
