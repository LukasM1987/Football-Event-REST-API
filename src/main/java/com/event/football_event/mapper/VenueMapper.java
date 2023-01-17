package com.event.football_event.mapper;

import com.event.football_event.domain.Venue;
import com.event.football_event.dto.TournamentDto;
import org.springframework.stereotype.Service;

@Service
public class VenueMapper {

    public Venue mapToVenue(final TournamentDto tournamentDto, final int i) {
            return new Venue(
                    tournamentDto.getEvents().get(i).getVenue().getId(),
                    tournamentDto.getEvents().get(i).getVenue().getName(),
                    tournamentDto.getEvents().get(i).getVenue().getCapacity(),
                    tournamentDto.getEvents().get(i).getVenue().getCityName(),
                    tournamentDto.getEvents().get(i).getVenue().getCountryName(),
                    tournamentDto.getEvents().get(i).getVenue().getMapCoordinates(),
                    tournamentDto.getEvents().get(i).getVenue().getCountryCode()
            );
    }
}
