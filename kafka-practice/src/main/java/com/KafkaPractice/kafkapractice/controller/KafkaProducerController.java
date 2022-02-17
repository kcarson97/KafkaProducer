package com.KafkaPractice.kafkapractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    private static final String TOPIC = "mytopic";

    @GetMapping("/publish/{message}")
    public String postMessage(@PathVariable("message") final String message){

        kafkaTemplate.send(TOPIC, message);

        return "Published successfully";

    }

    @GetMapping("/publish")
    public String test(){
        return "Test Successful";
    }
}
