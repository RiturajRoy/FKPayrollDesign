public class salaryClassification implements PaymentClassification
{
	public double salary;
	public salaryClassification(double salary) 
	{
        this.salary = salary;
    }
    public double calculatePay(Paycheck paycheck) {
      return salary;
    }
}