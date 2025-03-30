package com.example.homework03.feature.event.dto;

import com.example.homework03.domain.Venues;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventResponse {

    private Integer eventId;
    private String eventName;
    private LocalDateTime eventDate;
    private List<Integer> venuesList;
    private  List<Integer> attendeesList;
}
