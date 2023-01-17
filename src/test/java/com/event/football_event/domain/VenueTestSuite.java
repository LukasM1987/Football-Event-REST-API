package com.event.football_event.domain;

import com.event.football_event.repository.VenueRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class VenueTestSuite {

    @Autowired
    private VenueRepository venueRepository;

    @Test
    void addVenueTest() {
        //Given
        Venue venue = new Venue(
                "sr:venue:8329",
                "Elbasan Arena",
                12500,
                "Elbasan",
                "Albania",
                "41.115875,20.091992",
                "ALB");

        //When
        venueRepository.save(venue);
        Optional<Venue> id = venueRepository.findById(venue.getId());

        //Then
        Assertions.assertTrue(venueRepository.existsById("sr:venue:8329"));
        Assertions.assertNotNull(id);

        //CleanUp
        try {
            venueRepository.deleteById(venue.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
