public class ChangeDuesRate extends ChangeEmployee
{
  private final double newRate;
  public ChangeDuesRate(int empId, double newRate, Database db) {
    super(empId, db);
    this.newRate = newRate;
  }

  protected void change(Employee e) {
    e.duesrate = newRate;
    db.addEmployee(e.eId,e);
  }
}