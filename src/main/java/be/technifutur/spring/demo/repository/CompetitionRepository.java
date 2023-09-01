package be.technifutur.spring.demo.repository;

import be.technifutur.spring.demo.models.entity.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository extends JpaRepository<Competition,Long> {

    public boolean existsByName(String name);
}
