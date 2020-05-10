public class AddingUnionCharge
{
	public static void addingUnionCharge(int eId,UnionCharge ur,Database db)
	{
		Employee e=db.getEmployee(eId);
		e.dues+=ur.amount;
		db.addEmployee(e.eId,e);
	}
}