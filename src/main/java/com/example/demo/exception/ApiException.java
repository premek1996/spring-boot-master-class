package com.example.demo.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Builder
@Getter
public class ApiException {

    private final String message;
    private final Throwable throwable;
    private final ZonedDateTime zonedDateTime;

}

/*
record:
private final, getter, public constructor, equals, hashcode, toString
 */
