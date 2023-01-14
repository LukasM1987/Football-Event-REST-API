package com.event.football_event.mapper;

import com.event.football_event.domain.Tournament;
import com.event.football_event.dto.TournamentDto;
import org.springframework.stereotype.Service;


@Service
public class TournamentMapper {

    public Tournament mapToTournament(final TournamentDto tournamentDto) {
        Tournament tournament = new Tournament(
                tournamentDto.getId()
        );
        return tournament;
    }
}
