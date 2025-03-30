package com.example.homework03.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Attendees {

    private  Integer attendeeId;
    private String attendeeName;
    private String attendeeEmail;
}
