package rob.proto.bean.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Ensures that the first and last names of the {@link PersonBean} instance
 * provided are not empty or null.
 *
 * @author Rob Benton
 */
public class CheckNamesValidator implements ConstraintValidator<CheckNames, PersonBean>
{
    @Override
    public void initialize(CheckNames constraintAnnotation)
    {
    }

    @Override
    public boolean isValid(PersonBean personBean, ConstraintValidatorContext constraintValidatorContext)
    {
        String firstName = personBean.getFirstName();
        String lastName = personBean.getLastName();

        if (firstName == null || lastName == null)
        {
            return false;
        }

        return (firstName.length() == 0 || lastName.length() == 0);
    }
}
