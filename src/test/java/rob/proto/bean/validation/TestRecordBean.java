package rob.proto.bean.validation;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author Rob Benton
 */
public class TestRecordBean
{
    private static ValidatorFactory validatorFactory;
    private static Validator validator;
    private RecordBean recordBean;

    @BeforeClass
    public static void beforeClass()
    {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Before
    public void before()
    {
        recordBean = new RecordBean();
        AddressBean addressBean = new AddressBean();
        recordBean.setAddressBean(addressBean);
    }

    @Test
    public void testAllMissing()
    {
        Set<ConstraintViolation<RecordBean>> violations = validator.validate(recordBean);
        assertNotEquals(0, violations.size());
        printViolations(violations);
    }

    @Test
    public void testMissingAddress()
    {
        recordBean.setId(1);
        recordBean.setName("dummy");
        recordBean.setAddressBean(null);
        Set<ConstraintViolation<RecordBean>> violations = validator.validate(recordBean);
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

    private <T> void printViolations(Set<ConstraintViolation<T>> violations)
    {
        for (ConstraintViolation<T> v : violations)
        {
            System.out.println(v.getMessage());
        }
    }
}
