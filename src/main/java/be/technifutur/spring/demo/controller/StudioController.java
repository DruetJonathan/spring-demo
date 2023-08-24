package be.technifutur.spring.demo.controller;

import be.technifutur.spring.demo.models.dto.StudioDTO;
import be.technifutur.spring.demo.models.entity.Studio;
import be.technifutur.spring.demo.models.form.StudioForm;
import be.technifutur.spring.demo.service.StudioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studio")
public class StudioController {

    private final StudioService studioService;

    public StudioController(StudioService studioService) {
        this.studioService = studioService;
    }

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<StudioDTO> getOne(@PathVariable long id){
        Studio studio = studioService.getOne(id);
        StudioDTO body = StudioDTO.toDTO(studio);
        return ResponseEntity.ok(body);
    }

    @GetMapping
    public ResponseEntity<List<StudioDTO>> getAll(){
        List<Studio> studios = studioService.getAllStudios();
        List<StudioDTO> body = studios.stream()
                .map(StudioDTO::toDTO)
                .toList();
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("/{id:[0-9]+}")
    public ResponseEntity<?> delete(@PathVariable long id){
        studioService.removerStudio(id);
        return ResponseEntity.ok("deleted");
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody StudioForm form){
        Studio entity = form.toEntity();

        long body = studioService.addStudio(entity);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(body);
    }

    @PutMapping("/{id:[0-9]+}")
    public ResponseEntity<StudioDTO> update(@PathVariable long id, @RequestBody StudioForm form){
        Studio entity = form.toEntity();

        Studio studio = studioService.updateStudio(id, entity);
        StudioDTO body = StudioDTO.toDTO(studio);
        return ResponseEntity.ok(body);
    }
}
