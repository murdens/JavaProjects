
public class CheckingAccount extends BankAccount {
	
	private double limit;

	public CheckingAccount(long account, double balance, double limit) {
		super(account, balance);
		this.limit = limit;
		// TODO Auto-generated constructor stub
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}
	
	
}
