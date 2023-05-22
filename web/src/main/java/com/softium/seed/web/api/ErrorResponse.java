package com.softium.seed.web.api;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {

    String id;
    String message;
    String path;
    HttpStatus httpStatus;

    static ErrorResponse of(HttpStatus httpStatus, String message, String path) {
        return new ErrorResponse(UUID.randomUUID().toString(), message, path, httpStatus);
    }

}
