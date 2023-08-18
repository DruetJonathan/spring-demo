package be.technifutur.springdemo.service;

import be.technifutur.springdemo.entity.JeuVideo;
import be.technifutur.springdemo.entity.Plateform;
import be.technifutur.springdemo.repository.JeuVideoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JeuVideoServiceImpl implements JeuVideoService {
    JeuVideoRepository jeuVideoRepository;

    public JeuVideoServiceImpl(JeuVideoRepository jeuVideoRepository) {
        this.jeuVideoRepository = jeuVideoRepository;
    }

    @Override
    public void addJeuVideo(JeuVideo jeuVideo) {
        this.jeuVideoRepository.save(jeuVideo);
    }

    @Override
    public void deleteJeuVideo(JeuVideo jeuVideo) {
        this.jeuVideoRepository.delete(jeuVideo);
    }

    @Override
    public JeuVideo getById(Long id) {
        return this.jeuVideoRepository.findById(id).orElseThrow();
    }

    @Override
    public List<JeuVideo> getAll() {
        return this.jeuVideoRepository.findAll();
    }

    @Override
    public void modify(JeuVideo jeuVideo) {
        this.jeuVideoRepository.save(jeuVideo);
    }

    @Override
    public void modifyPrix(Double prix, Long id) {
        JeuVideo byId = this.jeuVideoRepository.getById(id);
        byId.setPrix(prix);
        this.jeuVideoRepository.save(byId);

    }

    @Override
    public void addPlateform(Plateform plateform, Long id) {
        JeuVideo byId = this.jeuVideoRepository.getById(id);
        byId.getPlateform().add(plateform);
        this.jeuVideoRepository.save(byId);
    }
}
