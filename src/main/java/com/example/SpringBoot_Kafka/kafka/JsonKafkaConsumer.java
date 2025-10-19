package com.example.SpringBoot_Kafka.kafka;

import com.example.SpringBoot_Kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "KafkaTopic_json", groupId = "myGroup")
    public void consume(@Payload User user) {
        LOGGER.info(String.format("Json Message received -> %s", user.toString()));
    }

//    @KafkaListener(topics = "KafkaTopic_json", groupId = "myGroup")
//    public void consumeRaw(User payload, @Headers Map<String, Object> headers) {
//        LOGGER.info("Payload type={}, value={}", payload.getClass(), payload);
//        LOGGER.info("Type header={}", headers.getOrDefault("type", headers.get("__TypeId__")));
//    }
}
