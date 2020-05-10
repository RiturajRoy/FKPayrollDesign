public class DeleteEmployee
{
    private int empId;
    private Database db;

    public DeleteEmployee(int empId, Database db) {
        this.empId = empId;
        this.db = db;
    }
    public void delete() {
        db.deleteEmployee(empId);
    }

}