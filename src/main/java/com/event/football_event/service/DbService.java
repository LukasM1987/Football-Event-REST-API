package com.event.football_event.service;

import com.event.football_event.domain.Competitor;
import com.event.football_event.domain.Event;
import com.event.football_event.domain.Tournament;
import com.event.football_event.domain.Venue;
import com.event.football_event.repository.CompetitorRepository;
import com.event.football_event.repository.EventRepository;
import com.event.football_event.repository.TournamentRepository;
import com.event.football_event.repository.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DbService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private CompetitorRepository competitorRepository;

    public void saveTournament(final Tournament tournament) {
        tournamentRepository.save(tournament);
    }

    public void saveVenue(final Venue venue) {
        venueRepository.save(venue);
    }

    public void saveEvent(final Event event) {
        eventRepository.save(event);
    }

    public void saveCompetitor(final Competitor competitor) {
        competitorRepository.save(competitor);
    }
}
