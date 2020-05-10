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
			System.out.println();
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
					   System.out.println("Employee record Added");
					   break;
				case 2:System.out.println("enter employee id to delete");
					   id=sc.nextInt();
					   DeleteEmployee de=new DeleteEmployee(id,db);
					   de.delete();
					   System.out.println("Employee record deleted");
					   break;
				case 3:	System.out.println("Press 1 to change name");
						System.out.println("Press 2 to change id");
						System.out.println("Press 3 to change address");
						System.out.println("Press 4 to change hourly rate");
						System.out.println("Press 5 to change salary rate");
						System.out.println("Press 6 to change commission rate");
						System.out.println("Press 7 to change dues rate");
						int cch=sc.nextInt();
						switch(cch)
						{
							case 1:System.out.println("Enter id and new name");
								   int eid=sc.nextInt();String newName=sc.next();
								   ChangeEmployee ce=new ChangeName(eid,newName,db);
								   Employee e=db.getEmployee(eid);
								   ce.execute();
								   System.out.println("Name Changed");
								   break;
							
							case 2:System.out.println("Enter id and new id");
								   eid=sc.nextInt();int newId=sc.nextInt();
								   ce=new ChangeId(eid,newId,db);
								   e=db.getEmployee(eid);
								   ce.execute();
								   System.out.println("Id Changed");
								   break;
							case 3:System.out.println("Enter id and new address");
								   eid=sc.nextInt();String newAddr=sc.next();
								   ce=new ChangeAddress(eid,newAddr,db);
								   e=db.getEmployee(eid);
								   ce.execute();
								   System.out.println("Address Changed");
								   break;
							case 4:System.out.println("Enter id and new hourly rate");
								   eid=sc.nextInt();double newRate=sc.nextDouble();
								   ChangeRateOrSalary cer=new ChangeRate(eid,newRate,db);
								   e=db.getEmployee(eid);
								   cer.change(e);
								   System.out.println("Rate Changed");
								   break;
							case 5:System.out.println("Enter id and new salary");
								   eid=sc.nextInt();double newSalary=sc.nextDouble();
								   cer=new ChangeSalary(eid,newSalary,db);
								   e=db.getEmployee(eid);
								   cer.change(e);
								   System.out.println("Salary Changed");
								   break;
							case 6:System.out.println("Enter id and new commission rate");
								   eid=sc.nextInt();double newCrate=sc.nextDouble();
								   ce=new ChangeCommRate(eid,newCrate,db);
								   e=db.getEmployee(eid);
								   ce.execute();
								   System.out.println("Commission rate Changed");
								   break;
							case 7:System.out.println("Enter id and new dues rate");
								   eid=sc.nextInt();double newDrate=sc.nextDouble();
								   ce=new ChangeDuesRate(eid,newDrate,db);
								   e=db.getEmployee(eid);
								   ce.execute();
								   System.out.println("Dues rate Changed");
								   break;
							default:System.out.println("Wrong Choice");
									break;
						}
						
						break;
				case 4:System.out.println("Enter employee id and amount");
					   id=sc.nextInt();double amount=sc.nextDouble();
					   SalesReceipt sr=new SalesReceipt(LocalDate.now(),amount);
					   AddingSalesReceipt.addingSalesReceipt(id,sr,db);
					   System.out.println("Sales receipt Added");
					   break;

				case 5:System.out.println("Enter employee id and union charge amount");
					   id=sc.nextInt();amount=sc.nextDouble();
					   UnionCharge ur=new UnionCharge(LocalDate.now(),amount);
					   AddingUnionCharge.addingUnionCharge(id,ur,db);
					   System.out.println("Union Charge Added");
					   break;
				case 6:System.out.println("Enter employee id and number of hours");
					   id=sc.nextInt();double hours=sc.nextDouble();
					   TimeCard tc=new TimeCard(LocalDate.now(),hours);
					   AddingTimeCard atc=new AddingTimeCard(LocalDate.now(),hours,id,db);
					   atc.execute();
					   System.out.println("Time Card Added");
					   break;
				case 7:Payroll proll=new Payroll(LocalDate.now(),db);
					   proll.calculatePay();
					   break;
				default:System.exit(0);
			}

		}
	}
}