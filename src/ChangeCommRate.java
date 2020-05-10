public class ChangeCommRate extends ChangeEmployee
{
  private final double newRate;
  public ChangeCommRate(int empId, double newRate, Database db) {
    super(empId, db);
    this.newRate = newRate;
  }

  protected void change(Employee e) {
    e.commrate = newRate;
    db.addEmployee(e.eId,e);
  }
}