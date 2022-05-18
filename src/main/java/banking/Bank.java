package banking;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
    private LinkedHashMap<Long, Account> accounts;
    private static AtomicLong numberGenerator = new AtomicLong(1L);

    private static long getNext() {
        return numberGenerator.getAndIncrement();
    }
    
    public Bank() {
        // complete the function
    	accounts = new LinkedHashMap<>();
    }

    private Account getAccount(Long accountNumber) {
        // complete the function
    	return accounts.get(accountNumber);

    }

    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        // complete the function
    	Long accNumber = getNext();
    	Account ca = new CommercialAccount(company, accNumber, pin, startingDeposit);
    	accounts.put(accNumber, ca);
        return accNumber;
    }

    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        // complete the function
    	Long accNumber = getNext();
    	Account ca = new ConsumerAccount(person, accNumber, pin, startingDeposit);
    	accounts.put(accNumber, ca);
        return accNumber;
    }

    public boolean authenticateUser(Long accountNumber, int pin) {
        // complete the function
    	
    	Account acc = getAccount(accountNumber);
    	if (acc == null) return false;
        return acc.validatePin(pin);
    }

    public double getBalance(Long accountNumber) {
        // complete the function
    	Account acc = getAccount(accountNumber);
    	if (acc == null) return -1;
    	return acc.getBalance();
    }

    public void credit(Long accountNumber, double amount) {
        // complete the function
    	Account acc = getAccount(accountNumber);
    	if (acc == null) return;
    	acc.creditAccount(amount);
    	return;
    }

    public boolean debit(Long accountNumber, double amount) {
        // complete the function
    	Account acc = getAccount(accountNumber);
    	if (acc == null) return false;
    	
        return acc.debitAccount(amount);
    }
}
