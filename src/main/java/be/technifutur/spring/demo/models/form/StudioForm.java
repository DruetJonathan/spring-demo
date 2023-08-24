package be.technifutur.spring.demo.models.form;

import be.technifutur.spring.demo.models.entity.Address;
import be.technifutur.spring.demo.models.entity.Game;
import be.technifutur.spring.demo.models.entity.Studio;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class StudioForm {
    private String name;

    private Address address;
    private List<Game> games;
    public Studio toEntity() {
        Studio studio = new Studio();
        studio.setName(name);
        studio.setAddress(address);
        studio.setGames(games);
    return studio;
    }
}
