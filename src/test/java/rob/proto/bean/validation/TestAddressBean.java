package rob.proto.bean.validation;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Rob Benton
 */
public class TestAddressBean
{
    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void beforeClass()
    {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    public void testBadZipCode()
    {
        AddressBean addressBean = new AddressBean();
        addressBean.setNumber(1);
        addressBean.setStreet("street");
        addressBean.setZipcode("123456");
        Set<ConstraintViolation<AddressBean>> violations = validator.validate(addressBean);
        assertNotEquals(0, violations.size());
        printViolations(violations);
    }

    @Test
    public void testGoodZipCode()
    {
        AddressBean addressBean = new AddressBean();
        addressBean.setNumber(1);
        addressBean.setStreet("street");
        addressBean.setZipcode("12345");
        Set<ConstraintViolation<AddressBean>> violations = validator.validate(addressBean);
        assertEquals(0, violations.size());
    }

    private <T> void printViolations(Set<ConstraintViolation<T>> violations)
    {
        for (ConstraintViolation<T> v : violations)
        {
            System.out.println(v.getMessage());
        }
    }
}
