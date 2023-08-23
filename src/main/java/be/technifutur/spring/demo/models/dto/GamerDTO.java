package be.technifutur.spring.demo.models.dto;

import be.technifutur.spring.demo.models.entity.Gamer;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class GamerDTO {
    private Long id;
    private String pseudo;
    private String email;
    private LocalDate birthdate;
    private boolean active = true;

    public static GamerDTO toDTO(Gamer entity){
        if (entity == null)
            return null;
        return GamerDTO.builder()
                .id(entity.getId())
                .pseudo(entity.getPseudo())
                .email(entity.getEmail())
                .birthdate(entity.getBirthdate())
                .active(entity.isActive())
                .build();
    }
}
