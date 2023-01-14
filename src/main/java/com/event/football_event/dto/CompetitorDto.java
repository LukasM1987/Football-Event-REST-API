package com.event.football_event.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompetitorDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("country")
    private String country;

    @JsonProperty("country_code")
    private String country_code;

    @JsonProperty("abbreviation")
    private String abbreviation;

    @JsonProperty("qualifier")
    private String qualifier;

    @JsonProperty("gender")
    private String gender;
}
