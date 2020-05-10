public class ChangeRate extends ChangeRateOrSalary
{
  private final double newRate;

  public ChangeRate(int empId, double newRate, Database db) {
    super(empId, db);
    this.newRate = newRate;
  }
  protected PaymentClassification getClassification() {
    return new HourlyClassification(newRate);
  }
  
}