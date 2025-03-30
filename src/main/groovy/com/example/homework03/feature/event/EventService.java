package com.example.homework03.feature.event;

import com.example.homework03.feature.event.dto.EventResponse;

import java.util.List;

public interface EventService {

       List<EventResponse> findAllEvent();
}
