package be.technifutur.springdemo.repository;

import be.technifutur.springdemo.entity.JeuVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JeuVideoRepository extends JpaRepository<JeuVideo,Long> {
}
