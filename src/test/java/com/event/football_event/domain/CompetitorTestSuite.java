package com.event.football_event.domain;

import com.event.football_event.repository.CompetitorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class CompetitorTestSuite {

    @Autowired
    private CompetitorRepository competitorRepository;

    @Test
    void addCompetitorTest() {
        //Given
        Competitor competitor = new Competitor(
                "sr:competitor:37863",
                "SS Folgore Falciano Calcio",
                "San Marino",
                "SMR",
                "FCC",
                "home",
                "male");

        //When
        competitorRepository.save(competitor);
        Optional<Competitor> id = competitorRepository.findById(competitor.getId());

        //Then
        Assertions.assertTrue(competitorRepository.existsById("sr:competitor:37863"));
        Assertions.assertNotNull(id);

        //CleanUp
        try {
            competitorRepository.deleteById(competitor.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
