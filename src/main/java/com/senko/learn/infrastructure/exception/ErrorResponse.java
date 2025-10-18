package com.senko.learn.infrastructure.exception;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private int errorCode;
    private String message;
}
