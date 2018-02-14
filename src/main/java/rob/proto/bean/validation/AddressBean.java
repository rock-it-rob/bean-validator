package rob.proto.bean.validation;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Rob Benton
 */
public class AddressBean
{
    @NotNull(message = "Must provide street number")
    private Integer number;

    @NotEmpty
    private String street;

    @ZipCode
    private String zipcode;

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

    public String getZipcode()
    {
        return zipcode;
    }

    public void setZipcode(String zipcode)
    {
        this.zipcode = zipcode;
    }
}
