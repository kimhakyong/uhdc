package com.example.uhdc.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseData {
    int httpStatus;
    String messageCode;
    String message;
    String exception;
    String propagation;
}
