import java.time.LocalDate;
public abstract class AddEmployee
{
    private int empId;
    private String name;
    private String address;
    private String pm;
    private boolean union;
    private double commrate;
    private double duesrate; 
    private LocalDate previouspaydate;
    private double wages;
    private double dues; 
    private Database db;

    public AddEmployee(int empId, String name, String address,String pm,boolean union,double commrate,double duesrate,LocalDate previouspaydate, Database db) 
    {
        this.empId = empId;
        this.name = name;
        this.address = address;
        this.pm=pm;
        this.union=union;
        this.db = db;
        this.commrate=commrate;
        this.duesrate=duesrate;
        this.previouspaydate=previouspaydate;
        this.wages=0.0;
        this.dues=0.0;
    }

    protected abstract PaymentClassification Classification();
    protected abstract PaymentSchedule Schedule();

    public void initialize() {
        PaymentClassification pc = Classification();
        PaymentSchedule ps = Schedule();
        Employee e = new Employee(empId, name, address,pm,union,commrate,duesrate,previouspaydate);
        e.pc = pc;
        e.ps = ps;
        db.addEmployee(empId, e);
        if(union==true)
            db.addUnionMember(empId,e);
    }
}