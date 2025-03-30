package com.example.homework03.feature.event;

import com.example.homework03.feature.event.dto.EventCreateRequest;
import com.example.homework03.feature.event.dto.EventResponse;

import java.util.List;

public interface EventService {

       List<EventResponse> findAllEvent(Integer page , Integer size);

       EventResponse findEventById(Integer eventId);

       EventResponse createEvent(EventCreateRequest eventCreateRequest);

       boolean deleteEvent(Integer eventId);


       EventResponse updateEvent(Integer id, EventCreateRequest eventCreateRequest);


}
