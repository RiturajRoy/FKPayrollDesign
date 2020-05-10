import java.time.LocalDate;

public class UnionCharge {

    public final LocalDate date;
    public final double amount;

    public UnionCharge(LocalDate date, double amount) {
        this.date = date;
        this.amount = amount;
    }
}