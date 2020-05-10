import java.time.LocalDate;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.FileWriter;
public class Runner
{
	public static void main(String args[])
	{
		System.out.println("Welcome to Employee Payroll System");
		Database db=new Database();
		while(true)
		{
			System.out.println("Press 1 to add employee");
			System.out.println("Press 2 to delete employee");
			System.out.println("Press 3 to change employee details");
			System.out.println("Press 4 to add sales receipt");
			System.out.println("Press 5 to add service tax");
			System.out.println("Press 6 to add a time card");
			System.out.println("Press 7 to run payroll for today");
			System.out.println("Press anything else to exit");
			
			int choice;
			Scanner sc=new Scanner(System.in);
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:System.out.println("Enter id,name ,address,payment method and commision rate");
					   int id=sc.nextInt();
					   String name=sc.next();
					   String addr=sc.next();
					   String pm=sc.next();
					   double commrate=sc.nextDouble();

					   System.out.println("Enter 1 if the employee belongs to  Union");
					   int ch=sc.nextInt();
					   double duesrate=0;boolean union=false;
					   if(ch==1)
					   {
					   	System.out.println("Enter duesrate");
					   	duesrate=sc.nextDouble();union=true;
					   }
					   System.out.println("Enter 1 for hourly salaried and anything else for monthly salaried");
					   ch=sc.nextInt();
					   if(ch==1)
					   {
					   		System.out.println("Enter hourly rate");
					   		double hourly=sc.nextDouble();
					   		AddEmployee e=new AddHourlyEmployee(id,name,addr,pm,union,commrate,duesrate,LocalDate.now(),hourly,db);
					   		e.initialize();
					   }
					   else
					   {
					   		System.out.println("Enter monthly salary");
					   		double salary=sc.nextDouble();
					   		AddEmployee e=new AddSalaryEmployee(id,name,addr,salary,pm,union,commrate,duesrate,LocalDate.now(),db);
					   		e.initialize();
					   }
					   break;
				case 2:System.out.println("enter employee id to delete");
					   id=sc.nextInt();
					   DeleteEmployee de=new DeleteEmployee(id,db);
					   de.delete();
					   break;
				case 3://write various change functions
						break;
				case 4:System.out.println("Enter employee id and amount");
					   id=sc.nextInt();double amount=sc.nextDouble();
					   SalesReceipt sr=new SalesReceipt(LocalDate.now(),amount);
					   AddingSalesReceipt.addingSalesReceipt(id,sr,db);
					   break;

				case 5:System.out.println("Enter employee id and union charge amount");
					   id=sc.nextInt();amount=sc.nextDouble();
					   UnionCharge ur=new UnionCharge(LocalDate.now(),amount);
					   AddingUnionCharge.addingUnionCharge(id,ur,db);
					   break;
				case 6:System.out.println("Enter employee id and number of hours");
					   id=sc.nextInt();double hours=sc.nextDouble();
					   TimeCard tc=new TimeCard(LocalDate.now(),hours);
					   AddingTimeCard atc=new AddingTimeCard(LocalDate.now(),hours,id,db);
					   atc.execute();
					   break;
				case 7:Payroll proll=new Payroll(LocalDate.now(),db);
					   proll.calculatePay();
					   break;
				default:System.exit(0);
			}

		}
	}
}