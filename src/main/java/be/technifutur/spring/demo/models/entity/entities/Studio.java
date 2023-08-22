package be.technifutur.spring.demo.models.entity.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studio_id",nullable = false)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "studio")
    private List<Game> games;

    @ManyToOne(optional = false)
    @JoinColumn(name = "studio_adress_id")
    private Address address;
}
