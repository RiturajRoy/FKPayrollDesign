public class AddSalaryEmployee extends AddEmployee {

    private double salary;

    public AddSalaryEmployee(int empId, String name, String address, double salary, String pm,boolean union,Database db) {
        super(empId, name, address,pm,union, db);
        this.salary = salary;
    }
    protected PaymentClassification Classification() {
        return new salaryClassification(salary);
    }
    protected PaymentSchedule Schedule() {
        return new Monthly();
    }
}