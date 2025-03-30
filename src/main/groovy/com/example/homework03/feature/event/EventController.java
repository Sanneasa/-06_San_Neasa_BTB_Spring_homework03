package com.example.homework03.feature.event;

import com.example.homework03.exception.ApiResponse;
import com.example.homework03.feature.event.dto.EventCreateRequest;
import com.example.homework03.feature.event.dto.EventResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
     public ResponseEntity <ApiResponse<List<EventResponse>>> findAllEvent( @Valid @RequestParam Integer page, @RequestParam Integer size){

         List<EventResponse> findEvent = eventService.findAllEvent(page,size);
         ApiResponse<List<EventResponse>> response = ApiResponse .<List<EventResponse>>  builder()
                 .message("Find event successfully...")
                 .httpStatus(HttpStatus.OK)
                 .timeStamp(LocalTime.now())
                 .payload(findEvent)
                 .build();
         return new ResponseEntity<>(response,HttpStatus.OK);
     }


    @GetMapping("/{event-id}")
    public ResponseEntity <ApiResponse<EventResponse>> findAllEvent(@Valid @PathVariable("event-id") Integer eventId){

        EventResponse findEvent = eventService.findEventById(eventId);
        ApiResponse<EventResponse> response = ApiResponse .<EventResponse>  builder()
                .message("Find event successfully...")
                .httpStatus(HttpStatus.OK)
                .timeStamp(LocalTime.now())
                .payload(findEvent)
                .build();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    @PutMapping("/{event-id}")
    public ResponseEntity <ApiResponse<EventResponse>> updateEvent(@Valid  @PathVariable("event-id") Integer id, EventCreateRequest eventCreateRequest ){

        EventResponse updateEvent = eventService.updateEvent(id,eventCreateRequest);
        ApiResponse<EventResponse> response = ApiResponse .<EventResponse>  builder()
                .message(" Update event successfully...")
                .httpStatus(HttpStatus.OK)
                .timeStamp(LocalTime.now())
                .payload(updateEvent)
                .build();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }



    @DeleteMapping("{event-id}")
    public ResponseEntity<ApiResponse<EventResponse>> deleteStudent(@PathVariable("event-id") Integer eventId) {
        Boolean deleted = eventService.deleteEvent(eventId);
        ApiResponse<EventResponse> response = ApiResponse.<EventResponse>builder()
                .message("The event has been deleted")
                .httpStatus(HttpStatus.OK)
                .build();
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity <ApiResponse<EventResponse>> findAllEvent( @Valid  @RequestBody EventCreateRequest eventCreateRequest){
        EventResponse addNewEvent = eventService.createEvent(eventCreateRequest);
        ApiResponse<EventResponse>response = ApiResponse .<EventResponse>  builder()
                .message("Add new event successfully...")
                .httpStatus(HttpStatus.OK)
                .timeStamp(LocalTime.now())
                .payload(addNewEvent)
                .build();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
