package be.technifutur.spring.demo.models.entity.entities;

import be.technifutur.spring.demo.models.entity.enums.DistributionMode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "podium_id",nullable = false)
    private Long id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "adress_id")
    private Address address;
    private LocalDate inscriptionStart;
    private LocalDate inscriptionEnd;
    private LocalDate competitionStart;
    private LocalDate competitionEnd;
    private double entry;
    private double cashPrize;

    @OneToOne
    private Podium podium;

    @Enumerated(EnumType.STRING)
    private DistributionMode distributionMode;
}
