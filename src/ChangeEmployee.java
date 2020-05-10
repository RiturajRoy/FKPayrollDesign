public abstract class ChangeEmployee
{
    private final int empId;
    private Database db;

    public ChangeEmployee(int empId, Database db) {
        this.empId = empId;
        this.db = db;
    }

    public void execute() {
        Employee e = db.getEmployee(empId);
        if (e != null) 
            change(e);
        else
            System.out.println("No such employee in record so change cannot take place,try adding!");
    }

    protected abstract void change(Employee e);
}