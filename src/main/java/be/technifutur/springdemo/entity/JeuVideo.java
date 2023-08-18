package be.technifutur.springdemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class JeuVideo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection(targetClass = Plateform.class)
    @Enumerated(EnumType.STRING)
    List<Genre> genre;

    Date dateDeSortie;

    String nomStudio;

    Double prix;

    @ElementCollection(targetClass = Plateform.class)
    @Enumerated(EnumType.STRING)
    List<Plateform> plateform;
}
