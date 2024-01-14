package com.study.services;

import com.study.models.Event;
import com.study.repos.HouseRepository;
import com.study.repos.EventRepository;
import com.study.repos.ApartmentRepository;
import com.study.repos.DebtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;

    @Autowired
    ApartmentRepository apartmentRepository;
    @Autowired
    HouseRepository houseRepository;
    @Autowired
    DebtorRepository debtorRepository;
    private Integer getIdFromEntity(Event event){
        return Integer.valueOf(event.getEntity().substring(event.getEntity().indexOf("=") + 1,
                event.getEntity().indexOf(",")));
    }

    private Event getExistingEvent(Event event){
        var events = eventRepository.findAll();
        var id = getIdFromEntity(event);

        var object = switch (event.getModel()) {
            case Apartment -> apartmentRepository.findById(id);
            case Houses -> houseRepository.findById(id);
            case Debtor -> debtorRepository.findById(id);
        };

        for (var event_ : events) {
            if (getIdFromEntity(event_).equals(id)) {
                event_.setEntity(object.toString());
                event_.setEventType(event.getEventType());
                return event_;
            }
        }
        return null;
    }
    public void save(Event event) {
        System.out.println(event);
        var event_ = getExistingEvent(event);
        System.out.println(event_);
        if (event_ == null){
            eventRepository.save(event);
            return;
        }

        eventRepository.save(event_);
    }
}