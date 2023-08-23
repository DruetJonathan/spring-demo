package be.technifutur.spring.demo.models.dto;

import be.technifutur.spring.demo.models.entity.Address;
import be.technifutur.spring.demo.models.entity.Game;
import be.technifutur.spring.demo.models.entity.Studio;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StudioDTO {
    private Long id;
    private String name;
    private Address address;
    private List<Game> games;
    public static StudioDTO toDTO(Studio studio){
        if (studio == null)
            return null;
        return StudioDTO.builder()
                .id(studio.getId())
                .name(studio.getName())
                .address(studio.getAddress())
                .games(studio.getGames())
                .build();
    }
}
