package com.event.football_event.mapper;

import com.event.football_event.domain.Venue;
import com.event.football_event.dto.TournamentDto;
import org.springframework.stereotype.Service;

@Service
public class VenueMapper {

    public Venue mapToVenue(final TournamentDto tournamentDto, final int size) {
            return new Venue(
                    tournamentDto.getEvents().get(size).getVenue().getId(),
                    tournamentDto.getEvents().get(size).getVenue().getName(),
                    tournamentDto.getEvents().get(size).getVenue().getCapacity(),
                    tournamentDto.getEvents().get(size).getVenue().getCity_name(),
                    tournamentDto.getEvents().get(size).getVenue().getCountry_name(),
                    tournamentDto.getEvents().get(size).getVenue().getMap_coordinate(),
                    tournamentDto.getEvents().get(size).getVenue().getCountry_code()
            );
    }
}
