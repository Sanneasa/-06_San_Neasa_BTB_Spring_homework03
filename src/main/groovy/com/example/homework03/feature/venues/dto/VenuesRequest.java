package com.example.homework03.feature.venues.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class VenuesRequest {

    @NotBlank(message ="Venues Name is Required...?")
    private String venuesName;

    @NotBlank(message ="Venues Location is Required...?")
    private String location;
}
