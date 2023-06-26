public class CarRental extends VehicleRental
{
    protected String CarModel;
    protected String CarType;
    protected int NumberOfSeat;
    protected String Color;
    
    public CarRental (String VehicleName, String regNum, int rental_days, String CarModel, String CarType,int NumberOfSeat, String Color)
    {
        super(VehicleName,regNum,rental_days);
        this.CarModel = CarModel;
        this.CarType = CarType;
        this.NumberOfSeat = NumberOfSeat;
        this.Color = Color;   
    }
    
    public String getCarModel()
    {
        return CarModel;
    }
    
    public String getCarType()
    {
        return CarType;
    }
    
    public int getNumberOfSeat()
    {
        return NumberOfSeat;
    }
    
    public String getColor()
    {
        return Color;
    }
    
    public double calcTotalPayment()
    {
        double rental_price, total;
        
        if (getCarModel().equalsIgnoreCase("A8"))
        {
            rental_price = 7000;
        }
        
        else if (getCarModel().equalsIgnoreCase("BMW 8 Series"))
        {
            rental_price = 12000;
        }
        
        else
        {
            rental_price = 80000;
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
        return ("Car brand: "+super.getVehicleName()+"\nCar model: "+getCarModel()+"\nCar type: "+getCarType()+"\nNumber of seats: "+getNumberOfSeat()+"\nCar colour: "+getColor()+"\nCar register number: "+super.getRegNum()+"\nRental days: "+super.getRentalDays());
    }
    
}
