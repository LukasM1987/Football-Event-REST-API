package com.event.football_event.repository;

import com.event.football_event.domain.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface EventRepository extends CrudRepository<Event, String> {

}
