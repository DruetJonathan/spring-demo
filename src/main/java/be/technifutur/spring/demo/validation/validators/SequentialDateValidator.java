package be.technifutur.spring.demo.validation.validators;

import be.technifutur.spring.demo.models.entity.Competition;
import be.technifutur.spring.demo.validation.contraints.SequentialDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SequentialDateValidator implements ConstraintValidator<SequentialDate, Competition> {
    @Override
    public boolean isValid(Competition competition, ConstraintValidatorContext constraintValidatorContext) {

        if(competition.getInscriptionStart() == null ||
                competition.getInscriptionEnd() == null ||
                competition.getCompetitionStart() == null ||
                competition.getCompetitionEnd() == null){
            return false;
        }

        return competition.getInscriptionStart().isBefore(competition.getInscriptionEnd()) &&
                competition.getInscriptionEnd().isBefore(competition.getCompetitionStart()) &&
                competition.getCompetitionStart().isBefore(competition.getCompetitionEnd());
    }
}

