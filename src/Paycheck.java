import java.time.LocalDate;

public class Paycheck {

  public LocalDate payDate;
  public LocalDate startDate;
  public double salary;
  public double dues;
  public double net;

  public Paycheck(LocalDate startDate, LocalDate payDate) {
    this.startDate = startDate;
    this.payDate = payDate;
  }
}