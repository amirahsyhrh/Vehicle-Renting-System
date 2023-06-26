public class Customer
{
    private String name;
    private String IC;
    private String address;
    private String phoneno;
    
    public Customer(String name, String IC, String address, String phoneno)
    {
        this.name = name;
        this.IC = IC;
        this.address = address;
        this.phoneno = phoneno;
    }
    
    public void setCustomer(String name, String IC, String address, String phoneno)
    {
        this.name = name;
        this.IC = IC;
        this.address = address;
        this.phoneno = phoneno;
    }
    
    public String getName()
    {
        return name;
    }
    
     public String getIC()
    {
        return IC;
    }
    
     public String getAddress()
    {
        return address;
    }
    
     public String getPhoneNo()
    {
        return phoneno;
    }
    
    public String toString()
    {
        return ("Customer name: "+name+"\nIC Number: "+IC+"\nAddress: "+address+"\nContact Number: "+phoneno);
    }
    
    
}