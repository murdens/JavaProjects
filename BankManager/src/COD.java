
public class COD extends BankAccount {
	
	private String expiry;

	public COD(long account, double balance, String expiry) {
		super(account, balance);
		this.expiry = expiry;
		// TODO Auto-generated constructor stub
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

}
