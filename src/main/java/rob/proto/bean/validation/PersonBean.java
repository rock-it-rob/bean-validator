package rob.proto.bean.validation;

/**
 * @author Rob Benton
 */
public class PersonBean
{
    private String firstName;
    private String lastName;

    public PersonBean()
    {
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
}
