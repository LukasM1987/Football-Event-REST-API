package com.event.football_event.repository;

import com.event.football_event.domain.Tournament;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TournamentRepository extends CrudRepository<Tournament, Long> {

}
