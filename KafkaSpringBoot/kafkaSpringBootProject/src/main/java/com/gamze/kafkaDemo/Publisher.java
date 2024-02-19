package com.gamze.kafkaDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Publisher {
    @Value(value ="${topic.name}" )
    private String topicName;
    @Autowired
    KafkaTemplate<String,String> template;
    public void sendMessage(String message){
        template.send(topicName, message);
    }
}
