package be.technifutur.spring.demo.models.form;

import be.technifutur.spring.demo.models.entity.Gamer;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class GamerForm {
    private String pseudo;

    private String email;

    private String password;

    private LocalDate birthdate;

    private boolean active = true;
    public Gamer toEntity() {
        Gamer gamer = new Gamer();
        gamer.setPseudo(pseudo);
        gamer.setEmail(email);
        gamer.setPassword(password);
        gamer.setBirthdate(birthdate);
        gamer.setActive(active);
        return gamer;
    }
}
