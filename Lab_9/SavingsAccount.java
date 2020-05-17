
public class SavingsAccount extends BankAccount{

private double rate = 0.025;
private int savingsNumber = 0;
private String accountNumber;


/**Constructor method getting name and initial amount and create an account
 * @param name name of the account holder
 * @param amount initial amount
 */
public SavingsAccount(String name, double amount) {
	super(name, amount);
	accountNumber = super.getAccountNumber()+"-"+savingsNumber;
	savingsNumber++;
}

public SavingsAccount(SavingsAccount newAccount, double amount) {
	super(newAccount, amount);
	savingsNumber++;
	accountNumber = super.getAccountNumber()+"-"+savingsNumber;
	
}

/**
 * This method will calculate one month's worth of interest on the balance and deposit it into the account.
 */
public void postInterest () {
	double monthlyRate = rate/12;
	double avgDailyBalance= super.getBalance()/30;
	double interestAmount = avgDailyBalance*monthlyRate*30;
	super.deposit(interestAmount);
}

public String getAccountNumber() {
	return accountNumber;
}


}
