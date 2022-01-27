package com.github.ivansavelyev.weatherservice.web.controller;

import com.github.ivansavelyev.weatherservice.model.Weather;
import com.github.ivansavelyev.weatherservice.repository.WeatherRepository;
import com.github.ivansavelyev.weatherservice.util.TimeUtil;
import com.github.ivansavelyev.weatherservice.util.WebUtil;
import com.github.ivansavelyev.weatherservice.web.exeption.WeatherException;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import static com.github.ivansavelyev.weatherservice.web.controller.WeatherController.REST_URL;

@RestController
@RequestMapping(value = REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class WeatherController {

    public static final String REST_URL = "api/rest";

    private final WeatherRepository weatherRepository;

    @GetMapping("/weather")
    public Weather get(@DateTimeFormat(pattern = TimeUtil.DATE_FORMAT_PATTERN)
                       @RequestParam(value = "localDate",
                               defaultValue = "#{T(java.time.LocalDate).now().toString()}") LocalDate localDate) {
        Weather weather;
        LocalDate today = LocalDate.now();
        if (localDate.isAfter(today)) {
            throw new WeatherException("We are not in future");
        } else if (localDate.isBefore(today)) {
            weather = weatherRepository.findByWeatherDate(localDate);
            if (weather == null) {
                throw new WeatherException("No previous data");
            } else {
                return weather;
            }
        } else {
            weather = weatherRepository.findByWeatherDate(localDate);
            if (weather == null) {
                return weatherRepository.save(new Weather(WebUtil.parseFromYandex()));
            } else {
                return weather;
            }
        }
    }
}
