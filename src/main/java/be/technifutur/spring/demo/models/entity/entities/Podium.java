package be.technifutur.spring.demo.models.entity.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Podium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "podium_id",nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "gamer_id")
    private Gamer gold;
    @ManyToOne
    @JoinColumn(name = "gamer_id")
    private Gamer silver;
    @ManyToOne
    @JoinColumn(name = "gamer_id")
    private Gamer bronze;

    @OneToOne
    private Competition competition;
}
