package com.github.ivansavelyev.weatherservice;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@AllArgsConstructor
public class WeatherService {

    public static void main(String[] args) {
        SpringApplication.run(WeatherService.class, args);
    }

}
