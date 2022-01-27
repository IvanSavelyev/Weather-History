package com.github.ivansavelyev.weatherservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "weather_history")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "weather_date", nullable = false, unique = true, updatable = false)
    private LocalDate weatherDate = LocalDate.now();

    @Column(name = "weather_value", nullable = false, unique = true, updatable = false)
    private String weatherValue;

    public Weather(String weatherValue) {
        this.weatherValue = weatherValue;
    }
}
