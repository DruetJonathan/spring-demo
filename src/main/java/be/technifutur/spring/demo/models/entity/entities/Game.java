package be.technifutur.spring.demo.models.entity.entities;

import be.technifutur.spring.demo.models.entity.enums.Genre;
import be.technifutur.spring.demo.models.entity.enums.Platform;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="game_id", nullable = false)
    private Long id;
    @Column(name="game_name", nullable = false)
    private String name;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "game_genre",
            joinColumns = @JoinColumn(name = "game_id")
    )
    private List<Genre> genres;

    @Column(name = "game_release")
    private LocalDate releaseDate;

    private String studioName;

    @Column(name = "game_price", nullable = false)
    private double price;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "game_platform",
            joinColumns = @JoinColumn(name = "game_id")
    )
    private List<Platform> platforms;


    @ManyToOne
    @JoinColumn(name = "game_studio_id", nullable = false)
    private Studio studio;

    @ManyToMany(mappedBy = "games")
    private Set<Gamer> gamers = new HashSet<>();

}
