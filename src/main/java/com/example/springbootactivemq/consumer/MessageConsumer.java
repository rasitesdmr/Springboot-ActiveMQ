package com.example.springbootactivemq.consumer;

import com.example.springbootactivemq.model.Message;
import com.example.springbootactivemq.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @Autowired
    MessageRepository messageRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

/*
  - MessageConsumer class'ı gelen mesajları alır.
  - Kuyruğun önünden bir mesaj alacak ve bir işlem gerçekleştirecek olan alıcıdır.
*/
    @JmsListener(destination = "rasitesdmr-queue") // Kuyruğun adını tanımlar
    public void messageListener(Message message) {
        LOGGER.info("Alınan mesaj : " + message);
        messageRepository.save(message);
    }
}
