public class CampervanRental extends VehicleRental
{
    protected String CampervanModel;
    protected String Features;
  
    
    public CampervanRental(String VehicleName, String regNum, int rental_days, String CampervanModel, String Features)
    {
        super(VehicleName,regNum,rental_days);
        this.CampervanModel = CampervanModel;
        this.Features = Features;
    }
    
    public String getCampervanModel()
    {
        return CampervanModel;
    }
    public String getFeatures()
    {
        return Features;
    }
    
    public double calcTotalPayment()
    {
        double rental_price = 0.0, total;
        
        if (getCampervanModel().equalsIgnoreCase("G 781C")) //Pilote
        {
            rental_price = 10000;
        }
        
        else if (getCampervanModel().equalsIgnoreCase("Liner Luxebale"))//Carthago
        {
            rental_price = 20000;
        }
        
        total = rental_price * super.getRentalDays();
        
        return total;
        
        
    }
    
    public double calcDeposit()
    {
        double deposit;
        
        deposit = calcTotalPayment() /2;
        
        return deposit;
    }
    
    public double calcBalance()
    {
        double balance;
        
        balance = calcTotalPayment() - calcDeposit();
        
        return balance;
    }
    
     public String toString()
    {
        return ("Campervan brand: "+super.getVehicleName()+"\nCampervan model: "+getCampervanModel()+"\nCampervan type: "+getFeatures()+"\nCampervan register number: "+super.getRegNum()+"\nRental days: "+super.getRentalDays());
    }
    
}
