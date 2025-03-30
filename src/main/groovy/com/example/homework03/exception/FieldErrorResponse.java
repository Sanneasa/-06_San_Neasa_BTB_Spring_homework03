package com.example.homework03.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Builder
public class FieldErrorResponse {
    String filed;
    String detail;
}
