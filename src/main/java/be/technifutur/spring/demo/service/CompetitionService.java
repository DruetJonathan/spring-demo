package be.technifutur.spring.demo.service;

import be.technifutur.spring.demo.models.entity.Competition;

public interface CompetitionService{

    Long add(Competition competition,Long gameId);

    void register(Long gamerId, Long competitionId);

    void unregister(Long gamerId, Long competitionId);
}
