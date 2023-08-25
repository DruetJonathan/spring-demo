package be.technifutur.spring.demo.validation.contraints;

import be.technifutur.spring.demo.models.entity.Genre;
import be.technifutur.spring.demo.models.entity.Platform;
import be.technifutur.spring.demo.validation.validators.ExcludeValidator;
import be.technifutur.spring.demo.validation.validators.TimesAgoValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Set;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExcludeValidator.class)
public @interface Exclude {
    String message() default "Value exclude";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @AliasFor("value")
    Genre[] genre() default {};
    @AliasFor("genre")
    Genre[] value() default {};



//    @AliasFor("plateform")
//    Platform[] value() default {};
//    @AliasFor("value")
//    Platform[] plateform() default {};


//    Platform plateform();
}
