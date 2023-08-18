package be.technifutur.springdemo.service;

import be.technifutur.springdemo.entity.JeuVideo;
import be.technifutur.springdemo.entity.Plateform;
import org.springframework.stereotype.Service;

import java.util.List;

public interface JeuVideoService {
    void addJeuVideo(JeuVideo jeuVideo);

    void deleteJeuVideo(JeuVideo jeuVideo);
    JeuVideo getById(Long id);
    List<JeuVideo> getAll();
    void modify(JeuVideo jeuVideo);
    void modifyPrix(Double prix, Long id);
    void addPlateform(Plateform plateform, Long id);

}
