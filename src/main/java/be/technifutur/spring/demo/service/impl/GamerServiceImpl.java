package be.technifutur.spring.demo.service.impl;

import be.technifutur.spring.demo.exceptions.ResourceNotFoundException;
import be.technifutur.spring.demo.models.entity.Game;
import be.technifutur.spring.demo.models.entity.Gamer;
import be.technifutur.spring.demo.models.entity.Platform;
import be.technifutur.spring.demo.repository.GamerRepository;
import be.technifutur.spring.demo.service.GameService;
import be.technifutur.spring.demo.service.GamerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service

public class GamerServiceImpl implements GamerService {
    private final GamerRepository gamerRepository;

    public GamerServiceImpl(GamerRepository gamerRepository) {
        this.gamerRepository = gamerRepository;
    }


    @Override
    public long addGamer(Gamer gamer) {
        gamer = gamerRepository.save(gamer);
        return gamer.getId();
    }

    @Override
    public Gamer removerGamer(long id) {
        Gamer gamer = getGamer(id);
        gamerRepository.delete(gamer);
        return gamer;
    }

    @Override
    public Gamer getGamer(long id) {
        return gamerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id, Game.class));
    }

    @Override
    public List<Gamer> getAllGamers() {
        return gamerRepository.findAll();
    }

    @Override
    public Gamer updateGamer(long id,Gamer gamer) {
        gamer.setId(id);
        return gamerRepository.save(gamer);
    }
}
