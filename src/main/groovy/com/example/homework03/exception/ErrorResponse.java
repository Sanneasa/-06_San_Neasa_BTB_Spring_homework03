package com.example.homework03.exception;

import lombok.Builder;

@Builder
public class ErrorResponse <T>{
      private Integer code;
      private T reason;
}
