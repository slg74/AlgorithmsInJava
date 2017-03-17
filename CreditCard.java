public class CreditCard {
	// Instance variables
	private String customer;
	private String bank;
	private String account;
	private int limit;
	protected double balance;

	public CreditCard(String cust, String bk, String acnt, int lim, double initialBal) {
		customer = cust;
		bank = bk;
		account = acnt;
		limit = lim;
		balance = initialBal;	
	}
	public CreditCard(String cust, String bk, String acnt, int lim) { this(cust, bk, acnt, lim, 0.0); }

	// Accessor methods
	public String getCustomer() { return customer; }
	public String getBank() { return bank; }
	public String getAccount() { return account; }
	public int getLimit() { return limit; }
	public double getBalance() { return balance; }

	public boolean charge(double price) {
		if (price + balance > limit)
			return false;
		// at this point, the charge is successful
		balance += price;
		return true;
	}	

	public void makePayment(double amount) {
		balance -= amount;
	}


	// Utility method to print card information
	public static void printSummary(CreditCard card) {
		System.out.print("Customer," + card.customer);
		System.out.print(",Bank,"    + card.bank);
		System.out.print(",Account," + card.account);
		System.out.print(",Balance," + card.balance);
		System.out.print(",Limit,"   + card.limit);
	}

	public static void main(String[] args) {
		CreditCard[] wallet = new CreditCard[3];
		wallet[0] = new CreditCard("David Bowman", "Lunar Savings", "0000 0000 0000 0000", 5000);
		wallet[1] = new CreditCard("Ellen Louise Ripley", "Xenomorph Bank and Trust", "0000 1111 2222 3333", 4444);
		wallet[2] = new CreditCard("Rick Deckard", "Los Angeles Off World Colony FCU", "9999 0000 0000 0000", 10000000, 300);

		for (int val = 1; val <= 16; val++) {
			wallet[0].charge(5*val);
			wallet[1].charge(2*val);
			wallet[2].charge(val);
		}

		for (CreditCard card : wallet) {
			CreditCard.printSummary(card);
			while (card.getBalance() > 200.0) {
				card.makePayment(200);
				System.out.println(",New_Balance," + card.getBalance());
			}
		}
	}
}
