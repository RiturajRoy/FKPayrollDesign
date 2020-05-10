public class ChangeId extends ChangeEmployee
{
  private final int newId;
  public ChangeId(int empId, int newId, Database db) {
    super(empId, db);
    this.newId = newId;
  }

  protected void change(Employee e) {
    e.eId = newId;
    db.addEmployee(e.eId,e);
  }
}