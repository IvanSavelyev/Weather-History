package com.github.ivansavelyev.weatherservice.web.exeption;

import lombok.Getter;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.http.HttpStatus;

import static org.springframework.boot.web.error.ErrorAttributeOptions.Include.MESSAGE;

@Getter
public class WeatherException extends AppException {

    public WeatherException(String msg) {
        super(HttpStatus.CONFLICT, msg, ErrorAttributeOptions.of(MESSAGE));
    }
}
