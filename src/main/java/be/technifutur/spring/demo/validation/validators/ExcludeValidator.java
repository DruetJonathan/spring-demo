package be.technifutur.spring.demo.validation.validators;

import be.technifutur.spring.demo.models.entity.Game;
import be.technifutur.spring.demo.models.entity.Genre;
import be.technifutur.spring.demo.validation.contraints.Exclude;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.Set;

public class ExcludeValidator implements ConstraintValidator<Exclude, Game> {

    private Exclude exclude;
    @Override
    public boolean isValid(Game game, ConstraintValidatorContext context) {

        for (Genre genre : exclude.genre()) {
            if (game.getGenres().contains(genre)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void initialize(Exclude constraintAnnotation) {
        exclude = constraintAnnotation;
    }
}
