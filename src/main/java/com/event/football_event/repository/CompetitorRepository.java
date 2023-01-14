package com.event.football_event.repository;

import com.event.football_event.domain.Competitor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompetitorRepository extends CrudRepository<Competitor, String> {

}

