package be.technifutur.springdemo.controller;

import be.technifutur.springdemo.entity.JeuVideo;
import be.technifutur.springdemo.entity.Plateform;
import be.technifutur.springdemo.service.JeuVideoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JeuVideoController {
    JeuVideoService jeuVideoService;

    public JeuVideoController(JeuVideoService jeuVideoService) {
        this.jeuVideoService = jeuVideoService;
    }

    @PostMapping("/jeuVideo/add")
    public ResponseEntity<?> add(@RequestBody JeuVideo jeuVideo){
        this.jeuVideoService.addJeuVideo(jeuVideo);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("/jeuVideo/delete/{id:[0-9]+}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        this.jeuVideoService.deleteJeuVideo(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/jeuVideo/all")
    public ResponseEntity<List<JeuVideo>> getAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.jeuVideoService.getAll());
    }

    @PostMapping("/jeuVideo/{id:[0-9]+}/modify")
    public ResponseEntity modify(@RequestBody JeuVideo jeuVideo,@PathVariable Long id){
        this.jeuVideoService.modify(jeuVideo);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PatchMapping("/jeuVideo/{id:[0-9]+}/modify/prix")
    public ResponseEntity modifyPrix(@RequestBody Double prix,@PathVariable Long id){
        this.jeuVideoService.modifyPrix(prix,id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PutMapping("/jeuVideo/{id:[0-9]+}/addPlateform")
    public ResponseEntity addPlateforme(@RequestBody Plateform plateform, @PathVariable Long id){
        this.jeuVideoService.addPlateform(plateform,id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
