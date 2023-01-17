package com.event.football_event.mapper;

import com.event.football_event.domain.Event;
import com.event.football_event.dto.TournamentDto;
import org.springframework.stereotype.Service;

@Service
public class EventMapper {

    public Event mapToEvent(final TournamentDto tournamentDto, final int size) {
            return new Event(
                    tournamentDto.getEvents().get(size).getSportEventId(),
                    tournamentDto.getEvents().get(size).getStartDate(),
                    tournamentDto.getEvents().get(size).getSportName(),
                    tournamentDto.getEvents().get(size).getCompetitionName(),
                    tournamentDto.getEvents().get(size).getCompetitionId(),
                    tournamentDto.getEvents().get(size).getSeasonName(),
                    tournamentDto.getEvents().get(size).getProbabilityHomeTeamWinner(),
                    tournamentDto.getEvents().get(size).getProbabilityDraw(),
                    tournamentDto.getEvents().get(size).getProbabilityAwayTeamWinner()
            );
    }
}
