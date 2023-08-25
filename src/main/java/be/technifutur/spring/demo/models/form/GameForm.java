package be.technifutur.spring.demo.models.form;

import be.technifutur.spring.demo.validation.contraints.Exclude;
import be.technifutur.spring.demo.models.entity.Game;
import be.technifutur.spring.demo.models.entity.Genre;
import be.technifutur.spring.demo.models.entity.Platform;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class GameForm {

    @NotBlank
    @Size(min = 5)
    private String name;
    @Exclude(value = {Genre.RTS,Genre.FPS})
    private Set<Genre> genres;
    @NotBlank
    @Past
    private LocalDate releaseDate;
    @NotBlank
    private Long studioId;
    @NotBlank
    @PositiveOrZero
    private double price;
    @NotBlank

    private Set<Platform> platforms;


    public Game toEntity(){
        Game game = new Game();
        game.setName( this.name );
        game.setGenres( this.genres );
        game.setReleaseDate( this.releaseDate );
        game.setPrice( this.price );
        game.setPlatforms( this.platforms );
        return game;
    }

}
