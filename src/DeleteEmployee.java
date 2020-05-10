public class DeleteEmployee
{
    private int empId;
    private Database db;

    public DeleteEmployee(int empId, Database db) {
        this.empId = empId;
        this.db = db;
    }
    public void delete() {
        if(db.employees.get(empId)!=null)
            db.deleteEmployee(empId);
        if(db.members.get(empId)!=null)
            db.deleteMember(empId);
    }

}