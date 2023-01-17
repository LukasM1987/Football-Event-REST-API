package com.event.football_event.mapper;

import com.event.football_event.domain.Competitor;
import com.event.football_event.dto.TournamentDto;
import org.springframework.stereotype.Service;

@Service
public class CompetitorMapper {

    public Competitor mapToCompetitor(final TournamentDto tournamentDto, final int i, final int j) {
                return new Competitor(
                        tournamentDto.getEvents().get(i).getCompetitors().get(j).getId(),
                        tournamentDto.getEvents().get(i).getCompetitors().get(j).getName(),
                        tournamentDto.getEvents().get(i).getCompetitors().get(j).getCountry(),
                        tournamentDto.getEvents().get(i).getCompetitors().get(j).getCountryCode(),
                        tournamentDto.getEvents().get(i).getCompetitors().get(j).getAbbreviation(),
                        tournamentDto.getEvents().get(i).getCompetitors().get(j).getQualifier(),
                        tournamentDto.getEvents().get(i).getCompetitors().get(j).getGender()
                );

    }
}
