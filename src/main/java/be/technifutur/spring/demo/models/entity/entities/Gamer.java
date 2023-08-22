package be.technifutur.spring.demo.models.entity.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Gamer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gamer_id",nullable = false)
    private Long id;

    private String pseudo;
    private String email;
    private String password;
    private LocalDate Birthdate;
    private Boolean actif;
    @ManyToMany(mappedBy = "gamers")
    private Set<Game> games = new HashSet<>();

    @ManyToOne()
    private Podium podium;
}
