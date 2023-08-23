package be.technifutur.spring.demo.service;

import be.technifutur.spring.demo.models.entity.Gamer;
import be.technifutur.spring.demo.models.entity.Studio;

import java.util.List;

public interface StudioService {

    Studio getOne(Long id);
    long addStudio(Studio gamer);
    Studio removerStudio(long id);
    List<Studio> getAllStudios();
    Studio updateStudio(long id,Studio studio);

}
