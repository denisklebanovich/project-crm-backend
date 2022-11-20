package com.dev.projectmanagementsystem.controllers;


import com.dev.projectmanagementsystem.models.Team;
import com.dev.projectmanagementsystem.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("/api/teams")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TeamController {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @PostMapping
    public ResponseEntity<Team> createTeam(@Valid @RequestBody Team team) {
        return ResponseEntity.ok(teamRepository.save(team));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteTeam(@PathVariable Long id) {
        teamRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
