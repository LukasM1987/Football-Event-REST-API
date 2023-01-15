package com.event.football_event.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VenueDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("capacity")
    private int capacity;

    @JsonProperty("city_name")
    private String city_name;

    @JsonProperty("country_name")
    private String country_name;

    @JsonProperty("map_coordinates")
    private String map_coordinates;

    @JsonProperty("country_code")
    private String country_code;
}
