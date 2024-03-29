package com.gamze.kafkaDemo;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConsumerConfiguration {

    @Value(value = "${kafka.server}")
    private String serverAddress;
    @Value(value = "${group.id}")
    private String groupId;
    @Bean
    public ConsumerFactory<String,String> consumerFactory(){
        Map<String, Object> configs =new HashMap<>();
        configs.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, serverAddress);
        configs.put(
                ConsumerConfig.GROUP_ID_CONFIG, groupId);
        configs.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(configs);
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,String>
    kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,String> factory= new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
