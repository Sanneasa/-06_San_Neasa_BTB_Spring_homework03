package com.example.homework03.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Events {

    private Integer eventId;
    private String eventName;
    private LocalDateTime  eventDate;
    private List<Venues> venuesList;
    private  List<Attendees> attendeesList;



}
