package com.example.homework03.feature.attendees.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class AttendeeRequest {

    @NotBlank(message="Attendee name cannot null.. ")
    private String attendeeName;

    @Email(message="Email attendee is required..")
    private String attendeeEmail;

}
