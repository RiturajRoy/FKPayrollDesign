public class ChangeAddress extends ChangeEmployee
{

  private final String newAddress;
  public ChangeAddress(int empId, String newAddress, Database db) {
    super(empId, db);
    this.newAddress = newAddress;
  }

  protected void change(Employee e) {
    e.address = newAddress;
    db.addEmployee(e.eId,e);
  }
}