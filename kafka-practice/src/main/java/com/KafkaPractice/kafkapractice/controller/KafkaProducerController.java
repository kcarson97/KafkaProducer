package com.KafkaPractice.kafkapractice.controller;

import com.KafkaPractice.kafkapractice.DataGenerator.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

/*
Rest controller running on localhost:8081
Swagger hub found at localhost:8081/swagger-ui/
 */

@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    /*
    User inputs the topic they want to post to, the rate at which
    the messages should be published and also the duration of the publishing.
    This is taken in the form of an html body
     */
    @PostMapping("/publish")
    public void publishData(@RequestBody Message msg){

        long startTime = System.currentTimeMillis();
        long elapsedTime = 0L;

        //run the script until the user inputted duration is met
        while(elapsedTime < msg.getDuration() * 60 * 1000){
            //publish a randomly generated quote/trade
            kafkaTemplate.send(msg.getTopic().toLowerCase(),msg.generateData());

            try{
                Thread.sleep(1000 / msg.getRate());
            }catch (InterruptedException ex){
                //posting interrupted
            }

            //update timer
            elapsedTime = (new Date()).getTime() - startTime;
        }
    }

}
