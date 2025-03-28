package com.example.demo.controllers;

import com.example.demo.model.Mensagem;
import com.example.demo.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {
    private final KafkaProducerService producerService;

    @Autowired
    public KafkaController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody Mensagem request) {
        producerService.sendMessage(request.getMensagem());
        return "Mensagem enviada: " + request.getMensagem();
    }
}
