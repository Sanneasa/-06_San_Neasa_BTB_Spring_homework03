package com.example.homework03.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Venues {
    private Integer venuesId;

    @NotBlank(message ="Venues Name is Required...?")
    private String venuesName;

    @NotBlank(message ="Venues Location is Required...?")
    private String location;
}
