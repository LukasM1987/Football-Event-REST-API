package com.event.football_event.mapper;

import com.event.football_event.domain.Event;
import com.event.football_event.dto.TournamentDto;
import org.springframework.stereotype.Service;

@Service
public class EventMapper {

    public Event mapToEvent(final TournamentDto tournamentDto, final int size) {
            return new Event(
                    tournamentDto.getEvents().get(size).getSport_event_id(),
                    tournamentDto.getEvents().get(size).getStart_date(),
                    tournamentDto.getEvents().get(size).getSport_name(),
                    tournamentDto.getEvents().get(size).getCompetition_name(),
                    tournamentDto.getEvents().get(size).getCompetition_id(),
                    tournamentDto.getEvents().get(size).getSeason_name(),
                    tournamentDto.getEvents().get(size).getProbability_home_team_winner(),
                    tournamentDto.getEvents().get(size).getProbability_draw(),
                    tournamentDto.getEvents().get(size).getProbability_away_team_winner()
            );
    }
}
