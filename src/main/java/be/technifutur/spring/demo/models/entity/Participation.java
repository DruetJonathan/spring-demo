package be.technifutur.spring.demo.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Participation {

    @EmbeddedId
    private ParticipationId id;

    @ManyToOne
    @MapsId("gamerId")
    @JoinColumn(name = "part_gamer_id")
    private Gamer gamer;

    @ManyToOne
    @MapsId("competId")
    @JoinColumn(name = "part_compet_id")
    private Competition competition;

    @Column(name = "part_position", nullable = true)
    private Integer position;

    @Embeddable
    @Getter @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class ParticipationId implements Serializable {

        private Long gamerId;
        private Long competId;

    }
}
