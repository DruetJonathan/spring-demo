package be.technifutur.spring.demo.service.impl;

import be.technifutur.spring.demo.exceptions.*;
import be.technifutur.spring.demo.models.entity.Competition;
import be.technifutur.spring.demo.models.entity.Game;
import be.technifutur.spring.demo.models.entity.Gamer;
import be.technifutur.spring.demo.models.entity.Participation;
import be.technifutur.spring.demo.repository.CompetitionRepository;
import be.technifutur.spring.demo.repository.GameRepository;
import be.technifutur.spring.demo.repository.GamerRepository;
import be.technifutur.spring.demo.repository.ParticipationRepository;
import be.technifutur.spring.demo.service.CompetitionService;
import org.springframework.stereotype.Service;
import static  be.technifutur.spring.demo.models.entity.Participation.ParticipationId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    private final CompetitionRepository competitionRepository;
    private final GameRepository gameRepository;
    private final GamerRepository gamerRepository;
    private final ParticipationRepository participationRepository;

    public CompetitionServiceImpl(CompetitionRepository competitionRepository,
                                  GameRepository gameRepository,
                                  GamerRepository gamerRepository,
                                  ParticipationRepository participationRepository) {
        this.competitionRepository = competitionRepository;
        this.gameRepository = gameRepository;
        this.gamerRepository = gamerRepository;
        this.participationRepository = participationRepository;
    }

    @Override
    public Long add(Competition competition, Long gameId) {
        competition.setId(null);

        List<String> fieldUniqueErrors = new LinkedList<>();
        if(competitionRepository.existsByName(competition.getName())){
            fieldUniqueErrors.add("name");
            throw new UniqueViolationException(fieldUniqueErrors);
        }
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new ResourceNotFoundException(gameId, Game.class));
        competition.setGamePlayed(game);
        return competitionRepository.save(competition).getId();
    }

    @Override
    public void register(Long gamerId, Long competitionId) {
        Gamer gamer = gamerRepository.findById(gamerId).orElseThrow(() -> new ResourceNotFoundException(gamerId, Gamer.class));
        Competition competition = competitionRepository.findById(competitionId).orElseThrow(() -> new ResourceNotFoundException(competitionId, Competition.class));
        if(competition.getMaxPlayer() >= competition.getParticipations().size()){
            throw new CapacityExceededException(competitionId, Competition.class);
        }
        if(competition.getParticipations().stream()
                .anyMatch(p -> p.getGamer().getId().equals(gamerId))){
            throw new ResourceAlreadyLinkedException(Competition.class,competitionId,Gamer.class,gamerId);
        }
        if(LocalDate.now().isAfter(competition.getInscriptionEnd())){
            throw new InscriptionCloseException();
        }
        Participation participation = new Participation();
        participation.setGamer(gamer);
        participation.setCompetition(competition);
        participationRepository.save(participation);
    }

    @Override
    public void unregister(Long gamerId, Long competitionId) {
        Competition competition = competitionRepository.findById(competitionId).orElseThrow(() -> new ResourceNotFoundException(competitionId, Competition.class));
        if(competition.getParticipations().stream()
                .noneMatch(p -> p.getId().equals(gamerId))){
            throw new ResourceNotFoundException(gamerId, Competition.class);
        }
        if(competition.getInscriptionEnd().isBefore(LocalDate.now())){
            throw new InscriptionCloseException("Cannot unregister from competition because inscription already ended");
        }
        ParticipationId participationId = new ParticipationId(gamerId,competitionId);
        Participation participation = participationRepository.findById(participationId).orElseThrow(() -> new ResourceNotFoundException(participationId, Participation.class));
        participationRepository.delete(participation);
    }
}
