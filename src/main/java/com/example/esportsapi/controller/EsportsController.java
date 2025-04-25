package com.example.esportsapi.controller;

import com.example.esportsapi.model.Game;
import com.example.esportsapi.model.Match;
import com.example.esportsapi.model.Team;
import com.example.esportsapi.model.Tournament;
import com.example.esportsapi.service.EsportsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EsportsController {

    private final EsportsService esportsService;

    public EsportsController(EsportsService esportsService) {
        this.esportsService = esportsService;
    }

    @GetMapping("/games")
    public ResponseEntity<List<Game>> getAllGames() {
        return ResponseEntity.ok(esportsService.getAllGames());
    }

    @GetMapping("/games/{gameId}")
    public ResponseEntity<Game> getGameById(@PathVariable String gameId) {
        return ResponseEntity.ok(esportsService.getGameById(gameId));
    }

    @GetMapping("/tournaments")
    public ResponseEntity<List<Tournament>> getAllTournaments() {
        return ResponseEntity.ok(esportsService.getAllTournaments());
    }

    @GetMapping("/tournaments/{tournamentId}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable String tournamentId) {
        return ResponseEntity.ok(esportsService.getTournamentById(tournamentId));
    }

    @GetMapping("/teams")
    public ResponseEntity<List<Team>> getAllTeams() {
        return ResponseEntity.ok(esportsService.getAllTeams());
    }

    @GetMapping("/teams/{teamId}")
    public ResponseEntity<Team> getTeamById(@PathVariable String teamId) {
        return ResponseEntity.ok(esportsService.getTeamById(teamId));
    }

    @GetMapping("/matches")
    public ResponseEntity<List<Match>> getAllMatches() {
        return ResponseEntity.ok(esportsService.getMatches());
    }

    @GetMapping("/matches-by-tourn/{tournamentId}")
    public ResponseEntity<List<Match>> getMatchesByTournament(@PathVariable String tournamentId) {
        return ResponseEntity.ok(esportsService.getMatchesByTournament(tournamentId));
    }

    @GetMapping("/matches/{matchId}")
    public ResponseEntity<Match> getMatchById(@PathVariable String matchId) {
        return ResponseEntity.ok(esportsService.getMatchById(matchId));
    }

}
