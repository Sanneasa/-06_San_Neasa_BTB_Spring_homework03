package com.example.homework03.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.time.LocalTime;


@AllArgsConstructor
@Data
@Builder
public class ApiResponse<T> {

    private String message;
    private HttpStatus httpStatus;
    private LocalTime timeStamp;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private  T payload;

}
