class Customer {
	static String accountNumber = "";

	public Customer() {
	}

	static String getAccountNumber() {
		return accountNumber;
	}
}

class CreditCardCustomer extends Customer {
	//can not override static method
	/*public String getAccountNumber() throws RuntimeException {
		return accountNumber;
	}*/
	
	public static String getAccountNumber() throws RuntimeException {
		return accountNumber;
	}
}