import java.time.LocalDate;
public interface PaymentSchedule {
  boolean isPayDate(LocalDate payDate);
}