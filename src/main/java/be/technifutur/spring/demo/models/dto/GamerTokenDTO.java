package be.technifutur.spring.demo.models.dto;

import be.technifutur.spring.demo.enums.Role;
import be.technifutur.spring.demo.models.entity.Gamer;
import lombok.Data;

@Data
public class GamerTokenDTO {

    private Long id;
    private String pseudo;
    private String email;
    private Role role;
    private String token;

    public GamerTokenDTO(Long id, String pseudo, String email, Role role) {
        this.id = id;
        this.pseudo = pseudo;
        this.email = email;
        this.role = role;
    }

    public static GamerTokenDTO fromEntity(Gamer gamer){
        return new GamerTokenDTO(gamer.getId(),gamer.getPseudo(), gamer.getEmail(), gamer.getRole());
    }
}
