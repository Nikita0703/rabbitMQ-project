package com.rabbit.rabbitmqproject.controller;

import com.rabbit.rabbitmqproject.dto.ValueMessage;
import com.rabbit.rabbitmqproject.producer.RabitMQProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class MessageController {

    private final RabitMQProducer rabitMQProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> sendNessage(@RequestBody ValueMessage message){
        rabitMQProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to Rabbit");
    }
}
