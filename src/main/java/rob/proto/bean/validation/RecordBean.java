package rob.proto.bean.validation;

import java.util.Date;

/**
 * @author Rob Benton
 */
public class RecordBean
{
    private Integer id;

    private String name;

    private Integer version;

    private String owner;

    private String ownerEmail;

    private Date lastUpdated;

    private AddressBean addressBean;

    public RecordBean()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getVersion()
    {
        return version;
    }

    public void setVersion(int version)
    {
        this.version = version;
    }

    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public String getOwnerEmail()
    {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail)
    {
        this.ownerEmail = ownerEmail;
    }

    public Date getLastUpdated()
    {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated)
    {
        this.lastUpdated = lastUpdated;
    }

    public AddressBean getAddressBean()
    {
        return addressBean;
    }

    public void setAddressBean(AddressBean addressBean)
    {
        this.addressBean = addressBean;
    }
}
