
public class CheckingAccount extends BankAccount{
private final static double FEE = 0.15;

/**constructor that takes a name and an initial amount as parameters
 * @param name name of the Account Holder
 * @param amount initial Amount
 */
public CheckingAccount(String name, double amount) {
	super(name, amount);
	super.setAccountNumber(super.getAccountNumber()+"-10");
}

public boolean withdraw(double amount) {
	boolean completed;
	amount=amount+FEE;
	completed = super.withdraw(amount);
	return completed;
}

}
