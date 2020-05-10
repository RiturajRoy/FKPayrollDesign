public class ChangeName extends ChangeEmployee
{
  private final String newName;
  public ChangeName(int empId, String newName, Database db) {
    super(empId, db);
    this.newName = newName;
  }

  protected void change(Employee e) {
    e.name = newName;
    db.addEmployee(e.eId,e);
  }
}