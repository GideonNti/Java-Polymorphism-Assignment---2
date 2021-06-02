



 class Volunteer extends StaffMember
{
 
   public Volunteer (String eName, String eAddress, String ePhone)
   {
      super (eName, eAddress, ePhone);
   }

   public double pay()
   {
      return 0.0;
   }
}


 class Executive extends Employee
{
   private double bonus;

   public Executive (String eName, String eAddress, String ePhone,
                     String socSecNumber, double rate)
   {
      super (eName, eAddress, ePhone, socSecNumber, rate);

      bonus = 0;
   }
   public void awardBonus (double execBonus)
   {
      bonus = execBonus;
   }

   public double pay()
   {
      double payment = super.pay() + bonus;

      bonus = 0;

      return payment;
   }
}



abstract  class StaffMember
{
   protected String name;
   protected String address;
   protected String phone;

   public StaffMember (String eName, String eAddress, String ePhone)
   {
      name = eName;
      address = eAddress;
      phone = ePhone;
   }
 public String toString()
   {
      String result = "Name: " + name + "\n";

      result += "Address: " + address + "\n";
      result += "Phone: " + phone;

      return result;
   }

   public abstract double pay();
}




 class Employee extends StaffMember
{
   protected String socialSecurityNumber;
   protected double payRate;
 
   public Employee (String eName, String eAddress, String ePhone,
                    String socSecNumber, double rate)
   {
      super (eName, eAddress, ePhone);

      socialSecurityNumber = socSecNumber;
      payRate = rate;
   }

  
   public String toString()
   {
      String result = super.toString();

      result += "\nSocial Security Number: " + socialSecurityNumber;

      return result;
   }

   public double pay()
   {
      return payRate;
   }
}


 class Hourly extends Employee
{
   protected int hoursWorked;
   public Hourly (String eName, String eAddress, String ePhone,
                  String socSecNumber, double rate)
   {
      super (eName, eAddress, ePhone, socSecNumber, rate);

      hoursWorked = 0;
   }

   public void addHours (int moreHours)
   {
      hoursWorked += moreHours;
   }

   public double pay()
   {
      double payment = payRate * hoursWorked;

      hoursWorked = 0;

      return payment;
   }

   public String toString()
   {
      String result = super.toString();

      result += "\nCurrent hours: " + hoursWorked;

      return result;
   }
}



 class Commission extends Hourly
{
	 double totalSales2, commissionRate, payment;
 
	public Commission (String eName, String eAddress, String ePhone,
            String socSecNumber, double rate, double commissionRate2)
	{
		super(eName, eAddress, ePhone, socSecNumber, rate);
		
		commissionRate = commissionRate2;
		
}
	public double addSales (double totalSales)
	
	{
		totalSales2 = totalSales;
		
		return totalSales2;
}
	
	public double pay()
	   {
	   payment = super.pay();  
		
	   payment += (totalSales2*commissionRate);
      
	  return payment;
 }
	
	public String toString(){ 
		String result = super.toString();
		
		 result += "\nTotal Sales: " + totalSales2;
		 result += "\nCommission: " + commissionRate;  
		 result += "\nTest: " + payment ; 
		 
	    return result;
}	
}


 class Staff{
StaffMember[] staffList;

public Staff (){
   staffList = new StaffMember[8];

   staffList[0] = new Executive ("Gideon", "Kwadaso",
      "254-125", "123-45-6789", 2423.07);

   staffList[1] = new Employee ("Dorothy", "Bantama",
      "660-5004", "987-65-4321", 1246.15);
   staffList[2] = new Employee ("Mabel", "Pampaso",
      "555-0000", "010-20-3040", 1169.23);

   staffList[3] = new Hourly ("Derrick", "Railway Sidels",
      "555-0690", "958-47-3625", 10.55);

   staffList[4] = new Volunteer ("Rhoda", "Anyinam",
      "300-4524");
   
   staffList[5] = new Volunteer ("Jethro", "Konongo",
      "555-7282");
   
   staffList[6] = new Commission ("Mannuella", "Tepa",
   "452-412", "023-32-3232", 6.25, 0.2);
   
   staffList[7] = new Commission ("Blesson", "Meduma",
 	      "312-5521", "076-23-4232", 9.75, 0.15);
   
   ((Executive)staffList[0]).awardBonus (500.00);

   ((Hourly)staffList[3]).addHours (40);
   ((Hourly)staffList[3]).addHours (40);
   ((Commission)staffList[6]).addHours (40);
   ((Commission)staffList[7]).addHours (35);
   ((Commission)staffList[6]).addSales (400);
   ((Commission)staffList[7]).addSales (950);
}

public void payday ()
{
   double amount;

   for (int count=0; count < staffList.length; count++)
   {
      System.out.println (staffList[count]);

      amount = staffList[count].pay();

      if (amount == 0.0)
         System.out.println ("Thank you");
      else
         System.out.println ("Amount Paid: " + amount);

      System.out.println (" ");
   }
}
}




public class Q1 {

	public static void main(String[] args) {
		System.out.println("Employee's payout system and other informations");
		System.out.println(" ");
		Staff obj = new Staff();

	      obj.payday();

	}

}
