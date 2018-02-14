package rob.proto.bean.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Rob Benton
 */
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.TYPE_USE,
ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.METHOD,
    ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.TYPE_PARAMETER
})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CheckNamesValidator.class})
public @interface CheckNames
{
    String message() default "{rob.proto.bean.validation.CheckNames.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
