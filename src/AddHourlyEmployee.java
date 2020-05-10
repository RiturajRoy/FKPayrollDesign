import java.time.LocalDate;
public class AddHourlyEmployee extends AddEmployee
{
    private final double hourlyRate;
    public AddHourlyEmployee(int empId, String name, String address, String pm,boolean union,double commrate,double duesrate,LocalDate previouspaydate,double hourlyRate,Database db) {
        super(empId, name, address,pm,union,commrate,duesrate,previouspaydate, db);
        this.hourlyRate = hourlyRate;
    }
    protected PaymentClassification Classification() {
        return new HourlyClassification(hourlyRate);
    }
    protected PaymentSchedule Schedule() {
        return new Weekly();
    }

}