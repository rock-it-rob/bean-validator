package rob.proto.bean.validation;

import org.junit.Before;

/**
 * @author Rob Benton
 */
public class TestRecordBean
{
    private RecordBean recordBean;

    @Before
    public void before()
    {
        recordBean = new RecordBean();
        recordBean.setAddressBean(new AddressBean());
    }
}
