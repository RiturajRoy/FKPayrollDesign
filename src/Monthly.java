import java.time.LocalDate;

public class Monthly implements PaymentSchedule
{
    public boolean isPayDate(LocalDate payDate)
    {
        return isEndOfMonth(payDate);
    }
    private boolean isEndOfMonth(LocalDate date)
    {
      return date.plusMonths(1).getMonth() == date.plusDays(1).getMonth();
    }
}