package com.example.SpringBoot_Kafka.controller;

import com.example.SpringBoot_Kafka.kafka.JsonKafkaConsumer;
import com.example.SpringBoot_Kafka.kafka.JsonKafkaProducer;
import com.example.SpringBoot_Kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/kafka")
public class JsonMessageController {

    private final JsonKafkaProducer jsonKafkaProducer;
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonMessageController.class);

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        LOGGER.info(String.format("Json Message received -> %s", user.toString()));
        jsonKafkaProducer.sendMessage(user);

        return ResponseEntity.ok("Json Message sent to Kafka Topic");
    }
}
