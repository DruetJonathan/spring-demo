package be.technifutur.spring.demo.validation.contraints;

import be.technifutur.spring.demo.validation.validators.ValidDateCompetitionValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidDateCompetitionValidator.class)
public @interface ValidDateCompetition {
    String message() default "no enough in the past";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
