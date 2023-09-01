package be.technifutur.spring.demo.models.form;

import be.technifutur.spring.demo.models.entity.Gamer;
import lombok.Data;

@Data
public class GamerLoginForm {

    private String pseudo;
    private String password;

    public Gamer toEntity(){
        Gamer gamer = new Gamer();
        gamer.setPseudo(this.pseudo);
        gamer.setPassword(this.password);
        return gamer;
    }
}
