package test;

public class Main {

	public static void main(String[] args) {
		// instantiate contacts manager object
		ContactsManager myContactsManager = new ContactsManager();
		
		// instantiate contact object and create 1st contact
		Contact friendGeorge = new Contact();
		
		friendGeorge.name = "George";
		friendGeorge.phoneNumber = "07739962448";
		
		myContactsManager.addContact(friendGeorge);
		
		//create 2nd contact
		Contact friendZippy =new Contact();
		
		friendZippy.name="Zippy";
		friendZippy.phoneNumber = "07739962446";
		
		myContactsManager.addContact(friendZippy);
		
		// creatr 3rd contact
		Contact friendBungle = new Contact();
		
		friendBungle.name="Bungle";
		friendBungle.phoneNumber = "07739962447";
		
		myContactsManager.addContact(friendZippy);

		
		//use contactmanager search method to find friend number
		Contact result = myContactsManager.searchContact("Zippy");
		
		System.out.println(result.phoneNumber);
	}

}
