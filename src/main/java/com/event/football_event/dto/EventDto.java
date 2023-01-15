package com.event.football_event.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDto {

    @JsonProperty("sport_event_id")
    private String sport_event_id;

    @JsonProperty("start_date")
    private String start_date;

    @JsonProperty("sport_name")
    private String sport_name;

    @JsonProperty("competition_name")
    private String competition_name;

    @JsonProperty("competition_id")
    private String competition_id;

    @JsonProperty("season_name")
    private String season_name;

    @JsonProperty("competitors")
    private List<CompetitorDto> competitors;

    @JsonProperty("venue")
    private VenueDto venue;

    @JsonProperty("probability_home_team_winner")
    private double probability_home_team_winner;

    @JsonProperty("probability_draw")
    private double probability_draw;

    @JsonProperty("probability_away_team_winner;")
    private double probability_away_team_winner;
}
