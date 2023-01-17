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
    private String sportEventId;

    @JsonProperty("start_date")
    private String startDate;

    @JsonProperty("sport_name")
    private String sportName;

    @JsonProperty("competition_name")
    private String competitionName;

    @JsonProperty("competition_id")
    private String competitionId;

    @JsonProperty("season_name")
    private String seasonName;

    @JsonProperty("competitors")
    private List<CompetitorDto> competitors;

    @JsonProperty("venue")
    private VenueDto venue;

    @JsonProperty("probability_home_team_winner")
    private double probabilityHomeTeamWinner;

    @JsonProperty("probability_draw")
    private double probabilityDraw;

    @JsonProperty("probability_away_team_winner;")
    private double probabilityAwayTeamWinner;
}
