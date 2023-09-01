package be.technifutur.spring.demo.validation.validators;

import be.technifutur.spring.demo.models.entity.Competition;
import be.technifutur.spring.demo.validation.contraints.MinSmallerMax;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MinSmallerMaxValidator implements ConstraintValidator<MinSmallerMax, Competition> {
    @Override
    public boolean isValid(Competition competition, ConstraintValidatorContext constraintValidatorContext) {
        return competition.getMinPlayer() <= competition.getMaxPlayer();
    }
}
