package rob.proto.bean.validation;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.*;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Rob Benton
 */
public class TestPersonBean
{
    private static Validator validator;
    private PersonBean personBean;

    @CheckNames
    private PersonBean checkNamesPerson;

    @BeforeClass
    public static void beforeClass()
    {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Before
    public void before()
    {
        personBean = new PersonBean();
        checkNamesPerson = new PersonBean();
    }

    @Test
    public void testRegularPerson()
    {
        Set<ConstraintViolation<PersonBean>> violations = validator.validate(personBean);
        printViolations(violations);
    }

    @Test
    public void testCheckNamesPerson()
    {
        Set<ConstraintViolation<TestPersonBean>> violations = validator.validateProperty(this, "checkNamesPerson");
        assertNotEquals(0, violations.size());
        printViolations(violations);
    }

    private <T> void printViolations(Set<ConstraintViolation<T>> violations)
    {
        for (ConstraintViolation<T> v : violations)
        {
            System.out.println(v.getMessage());
        }
    }
}
