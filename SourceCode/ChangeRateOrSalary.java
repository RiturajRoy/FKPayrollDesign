public abstract class ChangeRateOrSalary extends ChangeEmployee
{
  protected abstract PaymentClassification getClassification();
  public ChangeRateOrSalary(int empId, Database db) {
    super(empId, db);
  }
  protected void change(Employee e) {
    e.pc = getClassification();
    db.addEmployee(e.eId,e);
  }
}