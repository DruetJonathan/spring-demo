package be.technifutur.spring.demo.service;

import be.technifutur.spring.demo.models.entity.Gamer;

import java.util.List;

public interface GamerService {
    long addGamer(Gamer gamer);
    Gamer removerGamer(long id);
    Gamer getGamer(long id);
    List<Gamer> getAllGamers();
    Gamer updateGamer(long id,Gamer gamer);
}
