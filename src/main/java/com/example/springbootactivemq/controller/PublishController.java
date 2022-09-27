package com.example.springbootactivemq.controller;

import com.example.springbootactivemq.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishController {

    @Autowired
    private JmsTemplate jmsTemplate;  // JMS kuyruğuna gidip gelmek için kullanacağız.


    @PostMapping("/publishMessage")
    public ResponseEntity<String> publishMessage(@RequestBody Message message) {
        try {
            // "rasitesdmr-queue" adlı mesaj kuyruğuna mesaj gönder
            jmsTemplate.convertAndSend("rasitesdmr-queue", message); //Dönüştür ve gönder
            return new ResponseEntity<>("Sent", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
