
public class BankAccount {
	private String accID;
	private String accType;
	private double balance;
	private double interest;
	private double monthlyFee;
	private String owner;

	
	

	public BankAccount(String accID, String acc, String ownerID) {
		this.accID=accID;
		this.accType=acc;
		this.balance=0;
		this.interest=0;
		this.monthlyFee=0;
		this.owner = ownerID;
		
	}

	public String getOwnerID() {
		return owner;
	}

	public String getAccID() {
		return accID;
	}


	public String getAccType() {
		return accType;
	}


	public double getBalance() {
		return balance;
	}
	
	//will return the interest rate based on the account type
	public double getInterest() {
		switch(this.accType) {
		case "SeriousSaver":{
			if (balance <= 10000) {
				this.interest=0.05;
			}
			else {
				this.interest=0.08;
			break;
			}
		}
		case "FastSaver":{
			this.interest=0.05;
			break;
		}
		default:
			this.interest=0;
		}		
		return interest;
	}

	//will return monthly fee based on the account type
	public double getMonthlyFee() {
		switch(this.accType) {
		case "SeriousSaver":{
			if (balance <= 10000) {
				this.monthlyFee=5;}
			else {
				this.monthlyFee=0;}
			break;
		}
		case "FastSaver":{
			this.monthlyFee=0;
			break;
		}
		default:
			this.monthlyFee=0;
		}		
		return monthlyFee;
	}
	//this will set the balance when bankAccount objects are loaded back from text files
	//other than that balance can only be change by performing bank operations
	public void setBalance(double amount) {
		this.balance=amount;
	}
	
	// this will take money out of the account.
	public void withdraw(String ownerID, double amount) {
		BankSystem.addAmountRecord(ownerID, String.valueOf(balance));
		//this send a copy of amount record to the amount record list in Bank System
		balance-=amount;
		String line="-"+amount;
		BankSystem.addTransaction(ownerID,line);
		//this send a copy of transaction record to the transaction list in Bank System
	}
	
	public void deposit(String ownerID, double amount) {
		BankSystem.addAmountRecord(ownerID, String.valueOf(balance));
		balance+=amount;
		String line="+"+amount;
		BankSystem.addTransaction(ownerID, line);
	}
	
	public void transfer(String ownerID,double amount, BankAccount c) {
		BankSystem.addAmountRecord(ownerID, String.valueOf(balance));
		balance-=amount;
		c.deposit(c.accID,amount);
		//will transfer money through performing deposit for the given receiver account.
		String line="-"+amount;
		BankSystem.addTransaction(ownerID, line);
	}
	
	public static void main(String[] args) {
		
	}


}
