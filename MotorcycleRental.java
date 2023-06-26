public class MotorcycleRental extends VehicleRental
{
    protected String MotorcycleModel;
    protected String MotorcycleType;
    
    public MotorcycleRental(String VehicleName, String regNum, int rental_days,String MotorcycleModel, String MotorcycleType) 
    {
        super(VehicleName,regNum,rental_days);
        this.MotorcycleModel = MotorcycleModel;
        this.MotorcycleType = MotorcycleType;
    }
    
    public String getMotorcycleModel()
    {
        return MotorcycleModel;
    }
    public String getMotorcycleType()
    {
        return MotorcycleType;
    }
   
    
    public double calcTotalPayment()
    {
        double rental_price, total;
        
        if (getMotorcycleModel().equalsIgnoreCase("Ninja")) //Kawasaki
        {
            rental_price = 1000;
        }
        
        else if (getMotorcycleModel().equalsIgnoreCase("1400G7K"))//Kawasaki
        {
            rental_price = 1500;
        }
        
        else
        {
            rental_price = 700;
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
        return ("Motorcycle brand: "+super.getVehicleName()+"\nMotorcycle model: "+getMotorcycleModel()+"\nMotorcycle type: "+getMotorcycleType()+"\nMotorcycle register number: "+super.getRegNum()+"\nRental days: "+super.getRentalDays());
    }
    
}

