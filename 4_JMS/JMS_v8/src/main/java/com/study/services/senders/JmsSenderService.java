package com.study.services.senders;

import com.study.models.Event;
import com.study.models.EventType;
import com.study.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsSenderService {
    @Autowired
    private JmsTemplate jmsTemplate;

    public <T> void sendEvent(T entity, EventType eventType, Model model) {
        Event event = new Event();
        event.setEventType(eventType);
        event.setEntity(entity.toString());
        event.setModel(model);
        jmsTemplate.convertAndSend("event", event);
        jmsTemplate.convertAndSend("mail", event);
    }
}