package com.event.football_event.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "COMPETITORS")
public class Competitor {

    @Id
    @NonNull
    @Column(name = "COMPETITOR_ID", unique = true)
    private String id;

    @NonNull
    @Column(name = "NAME")
    private String name;

    @NonNull
    @Column(name = "COUNTRY")
    private String country;

    @NonNull
    @Column(name = "COUNTRY_CODE")
    private String country_code;

    @NonNull
    @Column(name = "ABBREVIATION")
    private String abbreviation;

    @NonNull
    @Column(name = "QUALIFIER")
    private String qualifier;

    @NonNull
    @Column(name = "GENDER")
    private String gender;

    @ManyToOne
    @JoinColumn(name = "SPORT_EVENT_ID")
    private Event event;

    public Competitor(String id, String name, String country, String country_code, String abbreviation, String qualifier, String gender) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.country_code = country_code;
        this.abbreviation = abbreviation;
        this.qualifier = qualifier;
        this.gender = gender;
    }
}