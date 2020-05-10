import java.time.LocalDate;
public class Weekly implements PaymentSchedule
{

	public boolean isPayDate(LocalDate payDate)
	{
    	return payDate.getDayOfWeek().getValue() == 5;
    }
}