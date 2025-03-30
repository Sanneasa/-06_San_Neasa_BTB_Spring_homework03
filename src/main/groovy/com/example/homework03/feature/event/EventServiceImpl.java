package com.example.homework03.feature.event;

import com.example.homework03.feature.event.dto.EventResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {


    private final  EventRepository eventRepository;
    EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository=eventRepository;
    }
    @Override
    public List<EventResponse> findAllEvent() {
        return eventRepository.findAllEvent();
    }
}
