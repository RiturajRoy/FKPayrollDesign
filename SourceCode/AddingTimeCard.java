import java.time.LocalDate;

public class AddingTimeCard
{
    private final LocalDate date;
    private final double workingHours;
    private final int empId;
    private Database db;

    public AddingTimeCard(LocalDate date, double workingHours, int empId,Database db) {
        this.date = date;
        this.workingHours = workingHours;
        this.empId = empId;
        this.db = db;
    }
    public void execute() {
        Employee e = db.getEmployee(empId);
        if (e != null) {
            PaymentClassification pc = e.pc;
            HourlyClassification hc = (HourlyClassification) pc;
            hc.addTimeCard(date, workingHours);
        }
    }

}