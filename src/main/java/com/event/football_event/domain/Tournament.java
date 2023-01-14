package com.event.football_event.domain;

import com.event.football_event.dto.EventDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TOURNAMENTS")
public class Tournament {

    @Id
    @NonNull
    @GeneratedValue
    @Column(name = "TOURNAMENT_ID")
    private Long id;

    @OneToMany(targetEntity = Event.class, mappedBy = "tournament", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Event> events = new ArrayList<>();

    public Tournament(Long id) {
        this.id = id;
    }
}
