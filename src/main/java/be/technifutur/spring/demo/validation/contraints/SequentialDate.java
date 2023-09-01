package be.technifutur.spring.demo.validation.contraints;

import be.technifutur.spring.demo.validation.validators.SuccessiveDateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = SuccessiveDateValidator.class)
public @interface SuccessiveDate {
    String message() default "The date should be sequential";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
