package com.event.football_event.output;

import com.event.football_event.dto.TournamentDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Result {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int HOME_TEAM = 0;
    private static final int AWAY_TEAM = 1;
    private static final int DATE_LENGTH = 19;
    private static final String BLUE = "\033[0;34m";
    private static final List<String> teams = new ArrayList<>();

    private int range;
    private boolean loop = true;

    public void compareCompetitors(final TournamentDto tournamentDto) {
        enterRange(tournamentDto);
        for (int i = 0; i < range; i++) {
            for (int j = 0; j < tournamentDto.getEvents().get(i).getCompetitors().size(); j++) {
                teams.add(tournamentDto.getEvents().get(i).getCompetitors().get(j).getName());
            }
            if (tournamentDto.getEvents().get(i).getVenue() == null) {
                compareProbabilityWithoutVenue(tournamentDto, i);
            } else {
                compareProbabilityWithVenue(tournamentDto, i);
            }
            teams.clear();
        }
    }

    private void compareProbabilityWithVenue(TournamentDto tournamentDto, int i) {
        if (tournamentDto.getEvents().get(i).getProbability_away_team_winner() > tournamentDto.getEvents().get(i).getProbability_home_team_winner()
                && tournamentDto.getEvents().get(i).getProbability_away_team_winner() > tournamentDto.getEvents().get(i).getProbability_draw()) {
            printResultWithVenue(SkirmishResult.WIN.getValue(), teams.get(HOME_TEAM), teams.get(AWAY_TEAM),
                    tournamentDto.getEvents().get(i).getVenue().getCity_name(),
                    tournamentDto.getEvents().get(i).getVenue().getName(),
                    tournamentDto.getEvents().get(i).getStart_date(),
                    teams.get(AWAY_TEAM));
        } else if (tournamentDto.getEvents().get(i).getProbability_home_team_winner() > tournamentDto.getEvents().get(i).getProbability_away_team_winner()
                && tournamentDto.getEvents().get(i).getProbability_home_team_winner() > tournamentDto.getEvents().get(i).getProbability_draw()) {
            printResultWithVenue(SkirmishResult.WIN.getValue(), teams.get(HOME_TEAM), teams.get(AWAY_TEAM),
                    tournamentDto.getEvents().get(i).getVenue().getCity_name(),
                    tournamentDto.getEvents().get(i).getVenue().getName(),
                    tournamentDto.getEvents().get(i).getStart_date(),
                    teams.get(HOME_TEAM));
        } else {
            printResultWithVenue(SkirmishResult.DRAW.getValue(), teams.get(HOME_TEAM), teams.get(AWAY_TEAM),
                    tournamentDto.getEvents().get(i).getVenue().getCity_name(),
                    tournamentDto.getEvents().get(i).getVenue().getName(),
                    tournamentDto.getEvents().get(i).getStart_date(),
                    null);
        }
    }

    private void compareProbabilityWithoutVenue(TournamentDto tournamentDto, int i) {
        if (tournamentDto.getEvents().get(i).getProbability_away_team_winner() > tournamentDto.getEvents().get(i).getProbability_home_team_winner()
                && tournamentDto.getEvents().get(i).getProbability_away_team_winner() > tournamentDto.getEvents().get(i).getProbability_draw()) {
            printResultWithoutVenue(SkirmishResult.WIN.getValue(), teams.get(HOME_TEAM), teams.get(AWAY_TEAM),
                    tournamentDto.getEvents().get(i).getStart_date(),
                    teams.get(AWAY_TEAM));
        } else if (tournamentDto.getEvents().get(i).getProbability_home_team_winner() > tournamentDto.getEvents().get(i).getProbability_away_team_winner()
                && tournamentDto.getEvents().get(i).getProbability_home_team_winner() > tournamentDto.getEvents().get(i).getProbability_draw()) {
            printResultWithoutVenue(SkirmishResult.WIN.getValue(), teams.get(HOME_TEAM), teams.get(AWAY_TEAM),
                    tournamentDto.getEvents().get(i).getStart_date(),
                    teams.get(HOME_TEAM));
        } else {
            printResultWithoutVenue(SkirmishResult.DRAW.getValue(), teams.get(HOME_TEAM), teams.get(AWAY_TEAM),
                    tournamentDto.getEvents().get(i).getStart_date(),
                    null);
        }
    }

    private void printResultWithVenue(final int skirmishResult, String awayTeam, String homeTeam, String city, String stadium, String date, String winner) {
        switch (skirmishResult) {
            case 0:
                System.out.println(BLUE + "{Event: " + homeTeam + " VS. " + awayTeam +
                        ", Where: " + city + ", " + stadium + ", When: " + date.substring(0, DATE_LENGTH) +
                        ", Skirmish Result: " + winner + " probably will be the winner.}");
                break;
            case 1:
                System.out.println(BLUE + "{Event: " + homeTeam + " VS. " + awayTeam +
                        ", Where: " + city + ", " + stadium + ", When: " + date.substring(0, DATE_LENGTH) +
                        ", Skirmish Result: Probably will be draw.}");
                break;
        }
    }

    private void printResultWithoutVenue(final int skirmishResult, String awayTeam, String homeTeam, String date, String winner) {
        switch (skirmishResult) {
            case 0:
                System.out.println(BLUE + "{Event: " + homeTeam + " VS. " + awayTeam +
                        ", When: " + date.substring(0, DATE_LENGTH) +
                        ", Skirmish Result: " + winner + " probably will be the winner.}");
                break;
            case 1:
                System.out.println(BLUE + "{Event: " + homeTeam + " VS. " + awayTeam +
                        ", When: " + date.substring(0, DATE_LENGTH) +
                        ", Skirmish Result: Probably will be draw.}");
                break;
        }
    }

    private void enterRange(TournamentDto tournamentDto) {
        while (loop) {
            System.out.println("Please enter results range: ");
            String enteredRange = scanner.next();
            parseRange(tournamentDto, enteredRange);
        }
    }

    private void parseRange(TournamentDto tournamentDto, String enteredRange) {
        try {
            range = Integer.parseInt(enteredRange);
            if (range > tournamentDto.getEvents().size() || range <= 0) {
                System.err.println("Range is to big, or is equals 0, or less then 0.");
            } else {
                loop = false;
            }
        } catch (Exception e) {
            System.err.println("This is not a number!");
        }
    }
}
