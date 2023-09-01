package be.technifutur.spring.demo.controller;

import be.technifutur.spring.demo.models.entity.Gamer;
import be.technifutur.spring.demo.models.form.CompetitionForm;
import be.technifutur.spring.demo.service.CompetitionService;
import be.technifutur.spring.demo.utils.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/competition")
@RestController
public class CompetitionController {

    private final CompetitionService competitionService;
    private final JwtUtil jwtUtil;

    public CompetitionController(CompetitionService competitionService,JwtUtil jwtUtil) {
        this.competitionService = competitionService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<Long> addCompetition(
            @RequestBody CompetitionForm form,
            @RequestParam Long gameId
            ){
        return ResponseEntity.ok(competitionService.add(form.toEntity(),gameId));
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("/{competitionId}")
    public ResponseEntity<?> register(
            Authentication authentication,
            @PathVariable Long competitionId){
        String token = authentication.getCredentials().toString();
        Long gamerId = jwtUtil.getId(token);
//        Object gamer = authentication.getPrincipal();
//        Long gamerId;
//        if(gamer instanceof Gamer g){
//            gamerId = g.getId();
//        }
        competitionService.register(gamerId,competitionId);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Gamer " + gamerId + " registered with success");
    }
    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{competitionId}")
    public ResponseEntity<?> unregister(
            Authentication authentication,
            @PathVariable Long competitionId
    ){
        String token = authentication.getCredentials().toString();
        Long gamerId = jwtUtil.getId(token);
        competitionService.unregister(gamerId,competitionId);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Gamer " + gamerId + " unregister successfully");
    }
}