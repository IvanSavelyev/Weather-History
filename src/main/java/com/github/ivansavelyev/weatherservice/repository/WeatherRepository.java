package com.github.ivansavelyev.weatherservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.ivansavelyev.weatherservice.model.Weather;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Transactional(readOnly = true)
public interface WeatherRepository extends CrudRepository<Weather, Integer> {

    Weather findByWeatherDate(LocalDate localDate);

    @Transactional
    Weather save(Weather weather);

    boolean existsByWeatherDate(LocalDate localDate);
}
