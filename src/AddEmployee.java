public abstract class AddEmployee
{
    private int empId;
    private String name;
    private String address;
    private String pm;
    private boolean union;
    private double salary;
    private double dues; 
    private Database db;

    public AddEmployee(int empId, String name, String address,String pm,boolean union, Database db) 
    {
        this.empId = empId;
        this.name = name;
        this.address = address;
        this.pm=pm;
        this.union=union;
        this.db = db;
        this.salary=0.0;
        this.dues=0.0;
    }

    protected abstract PaymentClassification Classification();
    protected abstract PaymentSchedule Schedule();

    public void initialize() {
        PaymentClassification pc = Classification();
        PaymentSchedule ps = Schedule();
        Employee e = new Employee(empId, name, address,pm,union);
        e.pc = pc;
        e.ps = ps;
        db.addEmployee(empId, e);
        if(union==true)
            db.addUnionMember(empId,e);
    }
}