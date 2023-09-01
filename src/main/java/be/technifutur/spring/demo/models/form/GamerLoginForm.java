package be.technifutur.spring.demo.models.form;

import be.technifutur.spring.demo.models.entity.Gamer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GamerLoginForm {
    @NotBlank
    @Size(min = 6,max = 20)
    private String pseudo;
    @NotBlank
    @Size(min = 6)
    @Pattern(regexp = "^(?=.*[!=@#|$%^&*()_+{}\\\\[\\\\]:;<>,.?~\\\\-]).*(?=.*[A-Z]).*(?=.*[0-9]).*$")
    private String password;

    public Gamer toEntity(){
        Gamer gamer = new Gamer();
        gamer.setPseudo(this.pseudo);
        gamer.setPassword(this.password);
        return gamer;
    }
}
