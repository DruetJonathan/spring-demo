package be.technifutur.spring.demo.models.dto.security;

import be.technifutur.spring.demo.models.Role;
import be.technifutur.spring.demo.models.entity.Gamer;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class GamerTokenDTO {
    private Long id;
    private String pseudo;
    private LocalDate birthdate;
    private Set<Role> roles;
    private String token;

    public static GamerTokenDTO fromEntity(Gamer gamer){
        GamerTokenDTO dto = new GamerTokenDTO();
        dto.setId(gamer.getId());
        dto.setPseudo(dto.getPseudo());
        dto.setBirthdate(gamer.getBirthdate());
        dto.setRoles(gamer.getRoles());
        return dto;
    }
}
