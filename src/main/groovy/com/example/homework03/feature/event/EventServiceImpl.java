package com.example.homework03.feature.event;

import com.example.homework03.feature.attendees.AttendeeRepository;
import com.example.homework03.feature.event.dto.EventCreateRequest;
import com.example.homework03.feature.event.dto.EventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventServiceImpl implements EventService {

    private final AttendeeRepository attendeeRepository;
    private final  EventRepository eventRepository;
    EventServiceImpl(AttendeeRepository attendeeRepository, EventRepository eventRepository) {
        this.attendeeRepository = attendeeRepository;
        this.eventRepository=eventRepository;
    }
    @Override
    public List<EventResponse> findAllEvent(Integer page, Integer size) {
        return eventRepository.findAllEvent(page,size);
    }

    @Override
    public EventResponse findEventById(Integer eventId) {
        return eventRepository.findEventById(eventId);
    }

    @Override
    public EventResponse createEvent(EventCreateRequest eventCreateRequest) {
        return  eventRepository.createEvent(eventCreateRequest);
    }

    @Override
    public boolean deleteEvent(Integer eventId) {
        return eventRepository.deleteEventById(eventId);
    }

    @Override
    public EventResponse updateEvent(Integer eventId, EventCreateRequest eventCreateRequest) {
           EventResponse eventResponse = eventRepository.updateEvent(eventId,eventCreateRequest);
           attendeeRepository.deletedEventEndAttendee(eventId);
           for(Integer attendeeId :eventCreateRequest.getAttendeesList()){

               attendeeRepository.addEventAndAttendee(eventId,attendeeId);
           }
           return  findEventById(eventResponse.getEventId());
    }
}
