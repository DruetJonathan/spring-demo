package be.technifutur.spring.demo.service.impl;

import be.technifutur.spring.demo.exceptions.ResourceNotFoundException;
import be.technifutur.spring.demo.models.entity.Studio;
import be.technifutur.spring.demo.repository.StudioRepository;
import be.technifutur.spring.demo.service.StudioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudioServiceImpl implements StudioService {

    private final StudioRepository studioRepository;

    public StudioServiceImpl(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    @Override
    public Studio getOne(Long id) {
        return studioRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException(id, Studio.class));
    }

    @Override
    public long addStudio(Studio gamer) {
        Studio save = studioRepository.save(gamer);
        return save.getId();
    }

    @Override
    public Studio removerStudio(long id) {
        Studio studio = getOne(id);
        studioRepository.delete(studio);
        return studio;
    }

    @Override
    public List<Studio> getAllStudios() {
        return studioRepository.findAll();
    }

    @Override
    public Studio updateStudio(long id,Studio studio) {
        studio.setId(id);
        return studioRepository.save(studio);
    }
}
