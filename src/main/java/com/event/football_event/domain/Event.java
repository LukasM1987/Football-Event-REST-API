package com.event.football_event.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "EVENTS")
public class Event {

    @Id
    @NotNull
    @Column(name = "SPORT_EVENT_ID", unique = true)
    private String sport_event_id;

    @NotNull
    @Column(name = "SPORT_EVENT_DATE")
    private LocalDateTime sport_event_date;

    @NotNull
    @Column(name = "SPORT_NAME")
    private String sport_name;

    @NotNull
    @Column(name = "COMPETITION_NAME")
    private String competition_name;

    @NotNull
    @Column(name = "COMPETITION_ID")
    private String competition_id;

    @NotNull
    @Column(name = "SEASON_NAME")
    private String season_name;

    @NotNull
    @Column(name = "PROBABILITY_HOME_TEAM_WINNER")
    private double probability_home_team_winner;

    @NotNull
    @Column(name = "PROBABILITY_DRAW")
    private double probability_draw;

    @NotNull
    @Column(name = "PROBABILITY_AWAY_TEAM_WINNER")
    private double probability_away_team_winner;

    @OneToMany(targetEntity = Competitor.class, mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Competitor> competitors = new ArrayList<>();

    @OneToMany(targetEntity = Venue.class, mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Venue> venues = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "TOURNAMENT_ID")
    private Tournament tournament;

    public Event(String sport_event_id, LocalDateTime sport_event_date, String sport_name, String competition_name, String competition_id, String season_name, double probability_home_team_winner, double probability_draw, double probability_away_team_winner) {
        this.sport_event_id = sport_event_id;
        this.sport_event_date = sport_event_date;
        this.sport_name = sport_name;
        this.competition_name = competition_name;
        this.competition_id = competition_id;
        this.season_name = season_name;
        this.probability_home_team_winner = probability_home_team_winner;
        this.probability_draw = probability_draw;
        this.probability_away_team_winner = probability_away_team_winner;
    }
}
