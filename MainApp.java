import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.text.*;
import java.lang.*;

public class MainApp
{
    public static void main (String [] args) throws IOException ,InterruptedException 
    {
   
        try
        {
            Scanner sc = new Scanner(System.in);
            final String password = "pass1234";
            final String username = "WAF";
            
            boolean pass = true;
            while (pass)
            {
                String answ = JOptionPane.showInputDialog("Enter your password: ");
                String next = JOptionPane.showInputDialog("Enter username : " );
                
                if(answ.equals(password) && next.equals(username))
                {
                    pass = false;
                }
                
                else
                {
                    System.out.println("Incorrect password or username. Please try again.");
                }
                
                Thread.sleep(200);
            }            
            String name, IC, phoneNo, address, ans, input;
            int loop, typeVehicle, typeCar, typeMotor,typeCampervan, rental_days, option;
            double sum1 = 0.0, sum2 = 0.0, sum3 = 0.0, sum4 = 0.0, sum5 = 0.0, sum6 = 0.0, sum7 = 0.0, sum8 = 0.0;
                
            
                

            //SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
            DecimalFormat df = new DecimalFormat("00.00");
                
            FileWriter fw = new FileWriter("receipt.txt");
            BufferedWriter bw = new BufferedWriter (fw);
            PrintWriter pwRes = new PrintWriter(bw);
                
            FileWriter FW = new FileWriter("dataCust.txt",true);
            BufferedWriter BW = new BufferedWriter (FW);
            PrintWriter out = new PrintWriter (BW);

            //another if statement here
            
            do{
                double totalCar, totalMotor, totalVan, totalAllCar= 0, totalAllVan = 0, totalAllMotor = 0;
                input = JOptionPane.showInputDialog ("1- Insert Booking Information \n2- Delete Data Customer");
                option = Integer.parseInt(input);
                if (option == 1)
                {
                    name = JOptionPane.showInputDialog("Enter Name : " );
                    IC = JOptionPane.showInputDialog("Enter IC number : ");
                    phoneNo =JOptionPane.showInputDialog("Enter phone number : ");
                    address = JOptionPane.showInputDialog("Enter Address : " );; 
                    
                    Customer x = new Customer (name, IC, phoneNo, address);
    
                    
                    input = JOptionPane.showInputDialog("How many vehicle do you want to rent : ");
                    loop = Integer.parseInt(input);
                    
                    //println for custInfo
                    out.println("Name :" + name);
                    out.println ("IC : " + IC);
                    out.println ("Phone number:" + phoneNo);
                    out.println("Address : " + address);
                    out.println ("Total vehicle : " + loop ); 
                    
                    //println for receipt
                    pwRes.println("RECEIPT");
                    pwRes.println("_________");
        
                    pwRes.println("Name :" + name);
                    pwRes.println ("IC : " + IC);
                    pwRes.println ("Phone number:" + phoneNo);
                    pwRes.println("Address : " + address);
                    pwRes.println ("Total vehicle : " + loop );   
                    
                    CarRental [] car = new CarRental[3];
                    CampervanRental[] van = new CampervanRental [2];
                    MotorcycleRental[] motor = new MotorcycleRental [3];
                    
                    
                    
                    for (int i = 0; i < loop ; i++)
                    {
                        
                        input = JOptionPane.showInputDialog("\n1- Car \n2- Motorcycle \n3- Campervan \nEnter type of vehicle :");
                        typeVehicle = Integer.parseInt(input);
                            //another if statement
                         if (typeVehicle == 1)
                         {
                             out.println ("Vehicle : Car" );
                             pwRes.println ("Vehicle : Car" );
                         }
                                    
                         else if (typeVehicle == 2)
                         {
                             out.println ("Vehicle : Motorcycle" );
                             pwRes.println ("Vehicle : Motorcycle" );
                         }
                         else
                         {
                             out.println ("Vehicle : Campervan" );
                             pwRes.println ("Vehicle : Campervan" );
                         }
                         
                         input = JOptionPane.showInputDialog("How many days do you want to rent :");
                         rental_days = Integer.parseInt(input);
                         
                         out.println ("Days rented : " + rental_days);
                         pwRes.println("Days rented : " + rental_days);
                            
                         if (typeVehicle == 1)
                         {
                             input = JOptionPane.showInputDialog("\n1- Audi A8 \n2- BMW 8 Series \n3- Lexus LC \nChoose your car type :");
                             typeCar = Integer.parseInt(input);
                             //if lagi
                             if (typeCar == 1)
                             {
                                 out.println ("Model : Audi A8" );
                                 pwRes.println ("Model : Audi A8" );
                             }
                             else if (typeCar == 2)
                             {
                                 out.println ("Model : BMW 8 Series" );
                                 pwRes.println("Model : BMW 8 Series" );
                             }
                             else
                             {
                                 out.println ("Model : Lexus LC" ); 
                                 pwRes.println("Model : Lexus LC" ); 
                             }
                                
                                            
                             FileReader fr1 = new FileReader ("CarDetails.txt");// for file input car
                             BufferedReader br1 = new BufferedReader (fr1);
                                
                             int z = 0;
                             String inline = null;
                             while ((inline=br1.readLine()) != null)
                             {
                                
                                 StringTokenizer st = new StringTokenizer(inline, ",");
                                 String brand = st.nextToken();
                                 String PlatNum = st.nextToken();
                                 String carModel = st.nextToken();
                                 String carType = st.nextToken ();
                                 int seat = Integer.parseInt(st.nextToken());
                                 String colour = st.nextToken();
                
                                 car[z] = new CarRental(brand, PlatNum, rental_days, carModel,
                                 carType, seat, colour);   
                                 z++;
                                    
                                 
                             }
                             
                             br1.close();    
                                
        
                             if (typeCar == 1)
                             {
                                 JOptionPane.showMessageDialog (null,car[0].toString() + "\nTotal price: RM "+df.format(car[0].calcTotalPayment()));
                                       //System.out.println("Advanced payment: RM "+df.format(car[0]. calcDeposit()));
                                       //System.out.println("Balance payment: RM "+df.format(car[0]. calcBalance()));
                                       
                                 totalCar = car[0].calcTotalPayment();
                                 sum1 += car[0].calcTotalPayment();
                                       //System.out.println("Total sales for a day: RM "+df.format(sum1));
                                       
                                 pwRes.println ("Total Price : RM " + df.format(car[0].calcTotalPayment()));
                                 pwRes.println("Advanced payment: RM "+df.format(car[0]. calcDeposit()));
                                 pwRes.println("Balance payment: RM "+df.format(car[0]. calcBalance()));
                                       
                                       
                                 out.println ("Total Price : RM " + df.format(car[0].calcTotalPayment()));
                                       
                                       
                             }
                             else if (typeCar == 2)
                             {
                                 JOptionPane.showMessageDialog (null,car[1].toString() + "\nTotal price: RM "+df.format(car[1].calcTotalPayment()));
                                    //System.out.println("Advanced payment: RM "+df.format(car[1]. calcDeposit()));
                                    //System.out.println("Balance payment: RM "+df.format(car[1]. calcBalance()));
                                    
                                 totalCar = car[1].calcTotalPayment();   
                                 sum2 += car[1].calcTotalPayment();
                                    //System.out.println("Total sales for a day: RM "+df.format(sum2));
                                    
                                 pwRes.println ("Total Price : RM " + df.format(car[1].calcTotalPayment()));
                                 pwRes.println("Advanced payment: RM "+df.format(car[1]. calcDeposit()));
                                 pwRes.println("Balance payment: RM "+df.format(car[1]. calcBalance()));
                                 out.println ("Total Price : RM " + df.format(car[1].calcTotalPayment()));
                             }
                             else
                             {
                                 JOptionPane.showMessageDialog (null,car[2].toString() + "\nTotal price: RM "+df.format(car[2].calcTotalPayment()));
                                    //System.out.println("Advanced payment: RM "+df.format(car[2]. calcDeposit()));
                                    //System.out.println("Balance payment: RM "+df.format(car[2]. calcBalance()));
                                     
                                 totalCar = car[2].calcTotalPayment();
                                 sum3 += car[2].calcTotalPayment();
                                    //System.out.println("Total sales for a day: RM "+df.format(sum3));
                                 pwRes.println ("Total Price : RM " + df.format(car[2].calcTotalPayment()));
                                 pwRes.println("Advanced payment: RM "+df.format(car[2]. calcDeposit()));
                                 pwRes.println("Balance payment: RM "+df.format(car[2]. calcBalance()));
                                 out.println ("Total Price : RM " + df.format(car[2].calcTotalPayment()));
                             }
                                
                                totalAllCar = totalAllCar + totalCar; 
                                
                            }//end type 1
                            
                            else if (typeVehicle == 2)
                            {
                                input = JOptionPane.showInputDialog("1- Kawasaki Ninja \n2- Kawasaki 1400G7K \n3- Honda Rebel \nChoose your motorcycle type : ");
                                typeMotor = Integer.parseInt(input);
                                
                                if (typeMotor == 1)
                                {
                                    out.println ("Model : Kawasaki Ninja" );
                                    pwRes.println ("Model : Kawasaki Ninja" );
                                 }
                                    
                                else if (typeMotor == 2)
                                {
                                    out.println ("Model : Kawasaki 1400G7K" );
                                    pwRes.println ("Model : Kawasaki 1400G7K" );
                                }
                                    
                                else
                                {
                                    out.println ("Model : Honda Rebel" );     
                                    pwRes.println ("Model : Honda Rebel" );     
                                }
                                    
                                    
                                FileReader fr2 = new FileReader ("MotorDetails.txt");// for file input motorcyle
                                BufferedReader br2 = new BufferedReader (fr2);
                                int m = 0;
                                String inline2 = null;
                                while ((inline2 =br2.readLine()) != null)
                                {
                               
                                    StringTokenizer st = new StringTokenizer(inline2, ",");
                                    String brandMO = st.nextToken();
                                    String PlatNumMO = st.nextToken();
                                    String ModelMO = st.nextToken();
                                    String TypeMO = st.nextToken ();
                                    /*boolean bool = false;
                                
                                    if (ModelMO.equalsIgnoreCase("Kawasaki Ninja"))
                                        bool = true;
                                    else if (ModelMO.equalsIgnoreCase("Kawasaki 1400G7K"))
                                        bool = true;
                                    else 
                                        bool = true;*/
                                
                                
                                    motor[m] = new MotorcycleRental(brandMO, PlatNumMO, rental_days,ModelMO
                                    ,TypeMO);
         
                                    m++;
                                } 
                                
                                if(typeMotor == 1)
                                {
                                    JOptionPane.showMessageDialog(null, motor[0].toString()+ "\nTotal price: RM "+df.format(motor[0].calcTotalPayment()));
                                     //System.out.println("Advanced payment: RM "+df.format(motor[0]. calcDeposit()));
                                      // System.out.println("Balance payment: RM "+df.format(motor[0]. calcBalance()));
                                    
                                       totalMotor = motor[0].calcTotalPayment();
                                    sum4 += motor[0].calcTotalPayment();
                                    //System.out.println("Total sales for a day: RM "+df.format(sum4));
                                    
                                    out.println ("Total Price : RM " + df.format(motor[0].calcTotalPayment()));
                                    pwRes.println ("Total Price : RM " + df.format(motor[0].calcTotalPayment()));
                                    pwRes.println("Advanced payment: RM "+df.format(motor[0]. calcDeposit()));
                                    pwRes.println("Balance payment: RM "+df.format(motor[0]. calcBalance()));
                                    
                                }
                                else if(typeMotor == 2)
                                {
                                    JOptionPane.showMessageDialog(null, motor[1].toString()+ "\nTotal price: RM "+df.format(motor[1].calcTotalPayment()));
                                    // System.out.println("Advanced payment: RM "+df.format(motor[1]. calcDeposit()));
                                       //System.out.println("Balance payment: RM "+df.format(motor[1]. calcBalance()));
                                     
                                       totalMotor = motor[1].calcTotalPayment();
                                     sum5 += motor[1].calcTotalPayment();
                                    //System.out.println("Total sales for a day: RM "+df.format(sum5));
                                    out.println ("Total Price : RM " + df.format(motor[1].calcTotalPayment()));
                                    pwRes.println ("Total Price : RM " + df.format(motor[1].calcTotalPayment()));
                                    pwRes.println("Advanced payment: RM "+df.format(motor[1]. calcDeposit()));
                                     pwRes.println("Balance payment: RM "+df.format(motor[1]. calcBalance()));
                                    
                                }
                                else
                                {
                                        JOptionPane.showMessageDialog(null, motor[2].toString()+ "\nTotal price: RM "+df.format(motor[2].calcTotalPayment()));
                                        // System.out.println("Advanced payment: RM "+df.format(motor[2]. calcDeposit()));
                                          // System.out.println("Balance payment: RM "+df.format(motor[2]. calcBalance()));
                                          totalMotor = motor[2].calcTotalPayment();  
                                         sum6 += motor[2].calcTotalPayment();
                                       // System.out.println("Total sales for a day: RM "+df.format(sum6));
                                        
                                        out.println ("Total Price : RM " + df.format(motor[2].calcTotalPayment()));
                                        pwRes.println ("Total Price : RM " + df.format(motor[2].calcTotalPayment()));
                                        pwRes.println("Advanced payment: RM "+df.format(motor[2]. calcDeposit()));
                                          pwRes.println("Balance payment: RM "+df.format(motor[2]. calcBalance()));
                                        
                                }
                                totalAllMotor = totalAllMotor + totalMotor;
                            br2.close();         
                            }//end type 2
                            
                            else
                            {
                                input = JOptionPane.showInputDialog("1-Pilote G 781C \n2-Carthago Liner Luxebale \nChoose your campervan type : ");
                                typeCampervan = Integer.parseInt(input);
                                
                                if (typeCampervan == 1)
                                {
                                    out.println ("Model : Pilote G 781C");
                                    pwRes.println ("Model : Pilote G 781C");
                                    
                                }
                                else
                                {
                                    out.println ("Model : Carthago Liner Luxebale" );
                                   pwRes.println ("Model : Carthago Liner Luxebale" );
                                    
                                }
                                
                                FileReader fr3 = new FileReader ("VanDetails.txt");// for file input van
                                BufferedReader br3 = new BufferedReader (fr3);
                                int v = 0;
                                String inline3 = null;
                                while ((inline3 =br3.readLine()) != null)
                                {
                               
                                    StringTokenizer st = new StringTokenizer(inline3, ",");
                                    String brandVAN = st.nextToken();
                                    String PlatNumVAN = st.nextToken();
                                    String ModelVAN = st.nextToken();
                                    String FeaturesVAN = st.nextToken();
                                    
                                    /*boolean bool = false;
                                
                                    if (ModelMO.equalsIgnoreCase("Kawasaki Ninja"))
                                        bool = true;
                                    else if (ModelMO.equalsIgnoreCase("Kawasaki 1400G7K"))
                                        bool = true;
                                    else 
                                        bool = true;*/
                                
                                
                                    van[v] = new CampervanRental(brandVAN, PlatNumVAN, rental_days, ModelVAN
                                    ,FeaturesVAN);
         
                                    v++;
                                }
                                
                                if(typeCampervan == 1)
                                {
                                    JOptionPane.showMessageDialog(null, van[0].toString() + "\nTotal price: RM "+df.format(van[0].calcTotalPayment()));

                                    
                                    totalVan = van[0].calcTotalPayment();
                                     sum6 += van[0].calcTotalPayment();
                                    
                                    out.println("Total price: RM "+df.format(van[0].calcTotalPayment()));
                                    pwRes.println("Total price: RM "+df.format(van[0].calcTotalPayment()));
                                    pwRes.println("Advanced payment: RM "+df.format(van[0]. calcDeposit()));
                                    pwRes.println("Balance payment: RM "+df.format(van[0]. calcBalance()));
                                    
                                    
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, van[1].toString() + "\nTotal price: RM "+df.format(van[1].calcTotalPayment()));
                                    //System.out.println("Advanced payment: RM "+df.format(van[1]. calcDeposit()));
                                   // System.out.println("Balance payment: RM "+df.format(van[1]. calcBalance()));
                                     
                                    totalVan = van[1].calcTotalPayment();
                                    sum7 += van[1].calcTotalPayment();
                                   // System.out.println("Total sales for a day: RM "+df.format(sum7));
                                    
                                   out.println("Total price: RM "+df.format(van[1].calcTotalPayment()));
                                   pwRes.println("Total price: RM "+df.format(van[1].calcTotalPayment()));
                                   pwRes.println("Advanced payment: RM "+df.format(van[1]. calcDeposit()));
                                   pwRes.println("Balance payment: RM "+df.format(van[1]. calcBalance()));
                                   
                                }

                                 totalAllVan = totalAllVan + totalVan;
                            br3.close();         
                          }//end motor 
                                
                           
 
                            
                            
                            
                         }//end of for
                         double totalAllVehicle = totalAllCar + totalAllVan + totalAllMotor;
                         JOptionPane.showMessageDialog(null,"\nOverall total price: RM: " + df.format(totalAllVehicle));
                         
                         
                                
                                
                         
                         
                         out.println("\nOverall total price: RM: " + df.format(totalAllVehicle));
                         pwRes.println("\nOverall total price: RM: " + df.format(totalAllVehicle));
                         
                         Date today = new Date( );
                         SimpleDateFormat sdf1;
                         sdf1 = new SimpleDateFormat( "MM/dd/yy" );

        
                         sdf1.format(today);

                         pwRes.println("Receipt Generated in : " + sdf1.format(today));
                    
                               
                         
                 }
                else 
                {
                    new FileOutputStream("dataCust.txt").close();
                    JOptionPane.showMessageDialog (null, "Data have been deleted");
                }  
                pwRes.close();
                ans = JOptionPane.showInputDialog("Have another customer? (Yes/No): ");            
                }while (ans.equalsIgnoreCase("YES"));
                out.close(); 
                

                
            }//end try
                catch (FileNotFoundException fnf)
                {
                    System.out.println (fnf.getMessage());
                }
        
                catch (IOException io)
                {
                    System.out.println(io.getMessage());
                }
                
                finally
                {
                    JOptionPane.showMessageDialog(null,"System end here.");
                }

    }
    
}