package be.technifutur.spring.demo.controller;

import be.technifutur.spring.demo.models.dto.GamerDTO;
import be.technifutur.spring.demo.models.dto.GamerTokenDTO;
import be.technifutur.spring.demo.models.entity.Gamer;
import be.technifutur.spring.demo.models.form.GamerForm;
import be.technifutur.spring.demo.models.form.GamerLoginForm;
import be.technifutur.spring.demo.service.GamerService;
import be.technifutur.spring.demo.utils.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gamer")
public class GamerController {

    private final GamerService gamerService;
    public GamerController(GamerService gamerService, JwtUtil jwtUtil) {
        this.gamerService = gamerService;
        this.jwtUtil = jwtUtil;
    }
    private JwtUtil jwtUtil;
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<Long> addGamer(@RequestBody @Valid GamerForm form){
        return ResponseEntity.status( HttpStatus.CREATED )
                .body( gamerService.add(form.toEntity()) );
    }
    @PreAuthorize("hasAuthority('ADMIN')")

    @GetMapping
    public ResponseEntity<List<GamerDTO>> getAll(){
        return ResponseEntity.ok(
                gamerService.getAll().stream()
                        .map(GamerDTO::toDTO)
                        .toList()
        );
    }

    @PostMapping("/login")
    public ResponseEntity<GamerTokenDTO> login(
            @RequestBody GamerLoginForm gamerLoginForm
    ){
        Gamer gamer = gamerService.login(gamerLoginForm.toEntity());
        GamerTokenDTO dto = GamerTokenDTO.fromEntity(gamer);
        dto.setToken(jwtUtil.generateToken(gamer));
        return ResponseEntity.ok(dto);
    }
    @PreAuthorize("hasAuthority('ADMIN')")

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<GamerDTO> getOne(@PathVariable Long id){
        return ResponseEntity.ok( GamerDTO.toDTO(gamerService.getOne(id)) );
    }
    @PreAuthorize("hasAuthority('ADMIN')")

    @PutMapping("/{id:[0-9]+}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid GamerForm form){
        gamerService.update( id, form.toEntity() );
        return ResponseEntity.noContent()
                .build();
    }
    @PreAuthorize("hasAuthority('ADMIN')")

    @DeleteMapping("/{id:[0-9]+}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        gamerService.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

    // PATCH - http://localhost:8080/gamer/1/add_game?gameId=1
    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("/{gamerId:[0-9]+}/add_game")
    public ResponseEntity<?> addGame(@PathVariable Long gamerId, @RequestParam Long gameId ){
        gamerService.addGame(gamerId, gameId);
        return ResponseEntity.noContent()
                .build();
    }
}
