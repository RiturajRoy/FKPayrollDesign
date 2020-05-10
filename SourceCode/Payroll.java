import java.util.*;
import java.time.LocalDate;

public class Payroll
{
  private final LocalDate payDate;
  private HashMap<Integer, Paycheck> paychecks = new HashMap<Integer, Paycheck>();
  private Database db;

  public Payroll(LocalDate payDate, Database db) {
    this.payDate = payDate;
    this.db = db;
  }
  public void calculatePay() {
    Collection<Employee> employees = db.getAllEmployees();
    for (Employee e : employees) {
      if (e.isPayDate(payDate)) {
        LocalDate startDate = e.previouspaydate; 
        Paycheck pc = new Paycheck(startDate, payDate);
        paychecks.put(e.eId, pc);
        pc=e.payDay(pc);
        System.out.println("Employee with id:"+e.eId+"  Name:"+e.name+" recieves a pay of "+pc.salary);
        e.previouspaydate=payDate;
        db.addEmployee(e.eId,e);
      }
    }
  }

}