import java.time.LocalDate;

public class TimeCard {
	public final LocalDate date;
    public final double hours;
    public TimeCard(LocalDate date, double hours) {
        this.date = date;
        this.hours = hours;
    }
}