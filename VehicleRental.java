public abstract class VehicleRental
{
    
    protected String VehicleName; 
    protected String regNum;
    protected int rental_days;

    
     public VehicleRental (String VehicleName, String regNum, int rental_days)
    {
       
        this.VehicleName = VehicleName;
        this.regNum = regNum;
        this.rental_days = rental_days;
        
    }
    
    
    
      public String getVehicleName()
    {
        return VehicleName;
    }
    
    public String getRegNum()
    {
        return regNum;
    }
    

    public int getRentalDays()
    {
        return rental_days;
    }
    
    
    
    public abstract double calcTotalPayment();// implemented by subclasses
    public abstract double calcDeposit();
    public abstract double calcBalance();
    

}