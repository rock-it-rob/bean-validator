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
        assertNotNull(violations);
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
        assertNotNull(violations);
        assertNotEquals(0, violations.size());
        printViolations(violations);
    }

    private void printViolations(Set<ConstraintViolation<RecordBean>> violations)
    {
        for (ConstraintViolation<RecordBean> v : violations)
        {
            System.out.println(v.getMessage());
        }
    }
}
