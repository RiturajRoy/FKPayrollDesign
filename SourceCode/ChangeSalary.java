public class ChangeSalary extends ChangeRateOrSalary
{
  private final double newSalary;

  public ChangeSalary(int empId, double newSalary, Database db) {
    super(empId, db);
    this.newSalary = newSalary;
  }
  protected PaymentClassification getClassification() {
    return new salaryClassification(newSalary);
  }
  
}