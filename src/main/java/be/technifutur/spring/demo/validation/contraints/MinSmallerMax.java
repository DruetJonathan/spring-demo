package be.technifutur.spring.demo.validation.contraints;

import be.technifutur.spring.demo.validation.validators.MinSmallerMaxValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = MinSmallerMaxValidator.class)
public @interface MinSmallerMax {

    String message() default "Min players must be smaller than max players";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
