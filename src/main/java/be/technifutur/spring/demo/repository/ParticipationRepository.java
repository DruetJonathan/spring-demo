package be.technifutur.spring.demo.repository;

import be.technifutur.spring.demo.models.entity.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import static  be.technifutur.spring.demo.models.entity.Participation.ParticipationId;

public interface ParticipationRepository extends JpaRepository<Participation,ParticipationId> {
}
