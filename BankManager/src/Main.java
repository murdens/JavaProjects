
public class Main {

	public static void main(String[] args) {
		
		CheckingAccount check = new CheckingAccount(1234321, 100.50, 200);
		SavingsAccount saving = new SavingsAccount(5679896, 1560.90, 0);
		COD cod = new COD(7894834, 6000.90, "1-1-2021");
		

		System.out.println("My Checking account number is "+ check.getAccount());
		System.out.println("My savings balance is "+ saving.getBalance());
		System.out.println("My COD expires: "+ cod.getExpiry());
	}

}
