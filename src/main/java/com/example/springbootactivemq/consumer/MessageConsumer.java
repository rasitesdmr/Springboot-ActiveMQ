package com.example.springbootactivemq.consumer;

import com.example.springbootactivemq.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    @JmsListener(destination ="rasitesdmr-queue" )
    public void messageListener(Message message){
        LOGGER.info("Mesaj alındı. {} " , message);
    }
}
