package com.example.homework03.feature.event.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventCreateRequest {

    @NotBlank(message = "Event name is required")
    private String eventName;

    @NotNull(message = "Event date is required")
    private LocalDateTime eventDate;

    @NotNull(message = " venues id is required")
    List<Integer> venuesList;

    @NotNull(message = " attendee id is required")
    private  List<Integer> attendeesList;
}
