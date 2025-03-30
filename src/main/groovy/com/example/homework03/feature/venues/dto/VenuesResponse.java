package com.example.homework03.feature.venues.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class VenuesResponse {

    private Integer venuesId;
    private String venuesName;
    private String location;

}
