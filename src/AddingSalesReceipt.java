public class AddingSalesReceipt
{
	void addingSalesReceipt(int eId,SalesReceipt sr,Database db)
	{
		Employee e=db.getEmployee(eId);
		e.wages+=e.commrate/100.0*sr.amount;
	}
}