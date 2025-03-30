package com.example.homework03.feature.event;

import com.example.homework03.exception.ApiResponse;
import com.example.homework03.feature.event.dto.EventResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    private final EventService  eventService;
    EventController(EventService eventService){
        this.eventService=eventService;
    }

     @GetMapping
     public ResponseEntity<ApiResponse<List<EventResponse>>> findAllEvent(){

         List<EventResponse> findEvent = eventService.findAllEvent();
         ApiResponse<List<EventResponse>> response = ApiResponse .<List<EventResponse>>  builder()
                 .message("Find attendee successfully...")
                 .httpStatus(HttpStatus.OK)
                 .timeStamp(LocalTime.now())
                 .payload(findEvent)
                 .build();
         return new ResponseEntity<>(response,HttpStatus.OK);
     }
}
