import java.time.LocalDate;
public class Employee 
{
    public int eId;
    public String name;
    public String address;
    public String pm;
    public boolean union;
    public PaymentClassification pc;
    public PaymentSchedule ps;
    public double salary=0.0;
    public double dues=0.0;


    public Employee(int eId, String name, String address,String pm,boolean union) 
    {
        this.eId = eId;
        this.name = name;
        this.address = address;
        this.pm=pm;
        this.union=union;
    }


    public Paycheck payDay(Paycheck paycheck) 
    {
        double salary = pc.calculatePay(paycheck);
        double dues=0;
        if(union==true)
            dues=this.dues;
        double net = salary - dues;
        paycheck.salary = salary;
        paycheck.dues = dues;
        paycheck.net = net;
        return paycheck;
    }


    public boolean isPayDate(LocalDate payDate) {
      return ps.isPayDate(payDate);
    }

}