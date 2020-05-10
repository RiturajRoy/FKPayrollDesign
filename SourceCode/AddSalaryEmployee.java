import java.time.LocalDate;
public class AddSalaryEmployee extends AddEmployee {

    private double salary;

    public AddSalaryEmployee(int empId, String name, String address, double salary, String pm,boolean union,double commrate,double duesrate,LocalDate previouspaydate,Database db) {
        super(empId, name, address,pm,union,commrate,duesrate,previouspaydate, db);
        this.salary = salary;
    }
    protected PaymentClassification Classification() {
        return new salaryClassification(salary);
    }
    protected PaymentSchedule Schedule() {
        return new Monthly();
    }
}