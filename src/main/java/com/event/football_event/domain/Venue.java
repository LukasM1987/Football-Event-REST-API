package com.event.football_event.domain;

import com.event.football_event.dto.EventDto;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "VENUES")
public class Venue {

    @Id
    @NotNull
    @Column(name = "VENUE_ID", unique = true)
    private String id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "CAPACITY")
    private int capacity;

    @NotNull
    @Column(name = "CITY_NAME")
    private String cityName;

    @NotNull
    @Column(name = "COUNTRY_NAME")
    private String countryName;

    @NotNull
    @Column(name = "MAP_COORDINATES")
    private String mapCoordinates;

    @NotNull
    @Column(name = "COUNTRY_CODE")
    private String countryCode;

    @ManyToOne
    @JoinColumn(name = "SPORT_EVENT_ID")
    private Event event;

    public Venue(String id, String name, int capacity, String cityName, String countryName, String mapCoordinates, String countryCode) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.cityName = cityName;
        this.countryName = countryName;
        this.mapCoordinates = mapCoordinates;
        this.countryCode = countryCode;
    }
}
