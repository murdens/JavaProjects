

public class SavingsAccount extends BankAccount {
	
	private float transfer;
	
	public SavingsAccount(long account, double balance, float transfer) {
		super(account, balance);
		this.transfer = transfer;
		// TODO Auto-generated constructor stub
	}

	public float getTransfer() {
		return transfer;
	}

	public void setTransfer(float transfer) {
		this.transfer = transfer;
	}
	
}

