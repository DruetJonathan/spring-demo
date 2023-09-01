package be.technifutur.spring.demo.controller;

import be.technifutur.spring.demo.models.form.CompetitionForm;
import be.technifutur.spring.demo.service.CompetitionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/competition")
@RestController
public class CompetitionController {

    private final CompetitionService competitionService;

    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @PostMapping
    public ResponseEntity<Long> addCompetition(
            @RequestBody CompetitionForm form,
            @RequestParam Long gameId
            ){
        return ResponseEntity.ok(competitionService.add(form.toEntity(),gameId));
    }


    @PostMapping("/{gamerId}/{competitionId}")
    public ResponseEntity<?> register(
            @PathVariable Long gamerId,
            @PathVariable Long competitionId){
        competitionService.register(gamerId,competitionId);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Gamer " + gamerId + " registered with success");
    }
    @DeleteMapping("/{gamerId}/{competitionId}")
    public ResponseEntity<?> unregister(
            @PathVariable Long gamerId,
            @PathVariable Long competitionId
    ){
        competitionService.unregister(gamerId,competitionId);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Gamer " + gamerId + " unregister successfully");
    }
}