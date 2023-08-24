package be.technifutur.spring.demo.controller;

import be.technifutur.spring.demo.models.dto.GamerDTO;
import be.technifutur.spring.demo.models.entity.Gamer;
import be.technifutur.spring.demo.models.form.GamerForm;
import be.technifutur.spring.demo.service.GameService;
import be.technifutur.spring.demo.service.GamerService;
import be.technifutur.spring.demo.service.StudioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gamer")
public class GamerController {

    private final GamerService gamerService;
    private final StudioService studioService;

    public GamerController(GamerService gamerService, StudioService studioService) {
        this.gamerService = gamerService;
        this.studioService = studioService;
    }

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<GamerDTO> getOne(@PathVariable long id){
        Gamer gamer = gamerService.getGamer(id);
        GamerDTO body = GamerDTO.toDTO(gamer);
        if (body.isActive())
            return ResponseEntity.ok(body);
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<GamerDTO>> getAll(){
        List<Gamer> gamers = gamerService.getAllGamers();
        List<GamerDTO> body = gamers.stream()
                .map(GamerDTO::toDTO)
                .filter(gamerDTO -> !gamerDTO.isActive())
                .toList();
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("/{id:[0-9]+}")
    public ResponseEntity<?> delete(@PathVariable long id){
        gamerService.removerGamer(id);
        return ResponseEntity.ok("deleted");
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody GamerForm form){
        Gamer entity = form.toEntity();
        long body = gamerService.addGamer(entity);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(body);
    }

    @PutMapping("/{id:[0-9]+}")
    public ResponseEntity<GamerDTO> update(@PathVariable long id, @RequestBody GamerForm form){
        Gamer entity = form.toEntity();
        Gamer gamer = gamerService.updateGamer(id, entity);
        GamerDTO body = GamerDTO.toDTO(gamer);
        return ResponseEntity.ok(body);
    }

}