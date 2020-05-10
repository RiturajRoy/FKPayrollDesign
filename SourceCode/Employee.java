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
    public double commrate;
    public double duesrate;
    public LocalDate previouspaydate;
    public double wages=0.0;
    public double dues=0.0;


    public Employee(int eId, String name, String address,String pm,boolean union,double commrate,double duesrate,LocalDate previouspaydate) 
    {
        this.eId = eId;
        this.name = name;
        this.address = address;
        this.pm=pm;
        this.union=union;
        this.commrate=commrate;
        this.duesrate=duesrate;
        this.previouspaydate=previouspaydate;
    }


    public Paycheck payDay(Paycheck paycheck) 
    {
        double salary = pc.calculatePay(paycheck);
        double dues=0;
        if(union==true)
            dues=this.dues+duesrate/100.0*salary;
        double net = salary + wages - dues;
        paycheck.salary = salary;
        paycheck.dues = dues;
        paycheck.net = net;
        wages=0;
        dues=0;
        return paycheck;
    }


    public boolean isPayDate(LocalDate payDate) {
      return ps.isPayDate(payDate);
    }

}