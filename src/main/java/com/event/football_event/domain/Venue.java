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
    private String city_name;

    @NotNull
    @Column(name = "COUNTRY_NAME")
    private String country_name;

    @NotNull
    @Column(name = "MAP_COORDINATE")
    private String map_coordinate;

    @NotNull
    @Column(name = "COUNTRY_CODE")
    private String country_code;

    @ManyToOne
    @JoinColumn(name = "SPORT_EVENT_ID")
    private Event event;

    public Venue(String id, String name, int capacity, String city_name, String country_name, String map_coordinate, String country_code) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.city_name = city_name;
        this.country_name = country_name;
        this.map_coordinate = map_coordinate;
        this.country_code = country_code;
    }
}
