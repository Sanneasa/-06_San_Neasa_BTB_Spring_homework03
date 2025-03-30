package com.example.homework03.feature.attendees.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttendeeResponse {

    private  Integer attendeeId;

    private String attendeeName;

    private String attendeeEmail;
}
