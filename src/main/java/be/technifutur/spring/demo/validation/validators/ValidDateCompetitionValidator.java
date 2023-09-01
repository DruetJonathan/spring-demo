package be.technifutur.spring.demo.validation.validators;

import be.technifutur.spring.demo.models.form.CompetitionForm;
import be.technifutur.spring.demo.validation.contraints.ValidDateCompetition;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class ValidDateCompetitionValidator implements ConstraintValidator<ValidDateCompetition,CompetitionForm> {


    @Override
    public void initialize(ValidDateCompetition constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(CompetitionForm value, ConstraintValidatorContext context) {

        return value.getCompetitionEnd().isAfter(value.getCompetitionStart()) &&
                value.getCompetitionStart().isAfter(value.getInscriptionEnd()) &&
                value.getCompetitionEnd().isAfter(value.getInscriptionStart());
    }
}
