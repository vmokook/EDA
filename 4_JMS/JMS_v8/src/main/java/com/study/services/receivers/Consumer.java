package com.study.services.receivers;

import com.study.models.Event;
import com.study.services.EmailService;
import com.study.services.EventService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class Consumer {
    @Autowired
    EventService eventService;

    @Autowired
    EmailService emailService;

    @JmsListener(destination = "event", containerFactory = "myFactory")
    public void receiveEvent(@NonNull Event event) {
        eventService.save(event);
    }

    @JmsListener(destination = "mail", containerFactory = "myFactory")
    public void receiveMail(@NonNull Event event) {
        emailService.send(event);
    }
}