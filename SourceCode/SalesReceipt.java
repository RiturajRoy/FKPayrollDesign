import java.time.LocalDate;

public class SalesReceipt {

    public final LocalDate date;
    public final double amount;

    public SalesReceipt(LocalDate date, double amount) {
        this.date = date;
        this.amount = amount;
    }
}