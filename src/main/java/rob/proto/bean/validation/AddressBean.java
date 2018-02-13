package rob.proto.bean.validation;

/**
 * @author Rob Benton
 */
public class AddressBean
{
    private Integer number;
    private String street;
    private Integer zipcode;

    public AddressBean()
    {
    }

    public Integer getNumber()
    {
        return number;
    }

    public void setNumber(Integer number)
    {
        this.number = number;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public Integer getZipcode()
    {
        return zipcode;
    }

    public void setZipcode(Integer zipcode)
    {
        this.zipcode = zipcode;
    }
}