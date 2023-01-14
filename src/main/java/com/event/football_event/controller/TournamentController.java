package com.event.football_event.controller;

import com.event.football_event.domain.Competitor;
import com.event.football_event.domain.Event;
import com.event.football_event.domain.Tournament;
import com.event.football_event.domain.Venue;
import com.event.football_event.dto.TournamentDto;
import com.event.football_event.mapper.CompetitorMapper;
import com.event.football_event.mapper.EventMapper;
import com.event.football_event.mapper.TournamentMapper;
import com.event.football_event.mapper.VenueMapper;
import com.event.football_event.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/tournament")
@RequiredArgsConstructor
public class TournamentController {

    private final DbService dbService;
    private final TournamentMapper tournamentMapper;

    private final EventMapper eventMapper;
    private final CompetitorMapper competitorMapper;
    private final VenueMapper venueMapper;

    @RequestMapping(method = RequestMethod.POST, value = "addTournament", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addTournament(@RequestBody final TournamentDto tournamentDto) {
        Tournament tournament = tournamentMapper.mapToTournament(tournamentDto);
        dbService.saveTournament(tournament);
        for (int i = 0; i < tournamentDto.getEvents().size(); i++) {
            Event event = eventMapper.mapToEvent(tournamentDto, i);
            dbService.saveEvent(event);
            for (int j = 0; j < tournamentDto.getEvents().get(i).getCompetitors().size(); j++) {
                Competitor competitor = competitorMapper.mapToCompetitor(tournamentDto, i, j);
                dbService.saveCompetitor(competitor);
            }
            Venue venue = venueMapper.mapToVenue(tournamentDto, i);
            dbService.saveVenue(venue);
        }
    }
}
