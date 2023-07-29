import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {
	
	private static ArrayList<Customer> customerList= new ArrayList<Customer>();
	private static ArrayList<BankAccount> accountList=new ArrayList<BankAccount>();
	private static ArrayList<BankAccount> deletedAccList=new ArrayList<BankAccount>();
	private static ArrayList<String> transactions= new ArrayList<String>();
	private static ArrayList<String> amountRecord= new ArrayList<String>();

	
	
    
	//this will add customer to the customer list
	public static void addCustomer(Customer customer) {
		customerList.add(customer);
	}
	//this will return the customer arraylist
	public static ArrayList<Customer> getCustomerList() {
		return customerList;
	}
	//this will add bank account to the accountlist
	public static void addAccount(BankAccount account) {
		accountList.add(account);
	}
	//this will remove bank account from the account list and will add it to deleted account record list
	public static void removeAccount(BankAccount account) {
		accountList.remove(account);
		deletedAccList.add(account);
	}
	
	//this will return the account arraylist
	public static ArrayList<BankAccount> getAccountList() {
		return accountList;
	}
	
	//this will check if customer exist
	//this will be use in creating account
	public static boolean customerExist(Customer cus) {
		boolean found=false;
		for(Customer customer:customerList) {
			if(customer.getFirstName().equals(cus.getFirstName()) && customer.getLastName().equals(cus.getLastName()) &&
					customer.getAddress().equals(cus.getAddress()) && customer.getPhone().equals(cus.getPhone()) &&
					customer.getEmail().equals(cus.getEmail()) && customer.getGender().equals(cus.getGender())) {
				found=true;
				break;
			}
		}
		return found;
	}
	//this will return bank account arraylist of a specific customer
	public static ArrayList<BankAccount> getCustomerAcc(Customer cus) {
		ArrayList<BankAccount> customerAcc= new ArrayList<BankAccount>();
    	for(BankAccount bank:accountList) {
    		if(bank.getOwnerID().equals(cus.getId())) {
    			customerAcc.add(bank);
    		}
    	}
		return customerAcc;
	}
	
	
	//this will return the arraylist of deleted account of a specific customer
	public static ArrayList<BankAccount> getDeletedAcc(Customer cus) {
		ArrayList<BankAccount> deletedAcc= new ArrayList<BankAccount>();
    	for(BankAccount bank:deletedAccList) {
    		if(bank.getOwnerID().equals(cus.getId())) {
    			deletedAcc.add(bank);
    		}
    	}
		return deletedAcc;
	}
	
	// this is adding string to the transaction list
	public static void addTransaction(String bankId, String Amount) {
		String transLine=bankId+","+Amount;
		transactions.add(transLine);
	
	}
	//this is adding string to the amount record list
	public static void addAmountRecord(String bankId, String Amount) {
		String amountLine=bankId+","+Amount;
		amountRecord.add(amountLine);
	}
	// this will get the transaction history of a specific customer
	public static ArrayList<String> getCusTransactions(String id) {
		ArrayList<String> trans=new ArrayList<String>();
		for(String line:transactions) {
			String[] item=line.split(",");
			if (item[0].equalsIgnoreCase(id)) {
				trans.add(item[1]);
				
			}
		}
		return trans;
	}

	//this will return the amount record of the specific customer
	public static ArrayList<String> getCusAmount(String id) {
		ArrayList<String> aRec=new ArrayList<String>();
		for(String line:amountRecord) {
			String[] item=line.split(",");
			if (item[0].equalsIgnoreCase(id)) {
				aRec.add(item[1]);
				
			}
		}
		return aRec;
	}
	
	//this will load stored data in the textfiles back to the corresponding list
	public static void read() {
		//loading customers back to arraylist
		try {
			File file=new File("src/customerlist.txt");
			Scanner scan=new Scanner(file);
		
			while(scan.hasNextLine()) {
				String line=scan.nextLine();
				String[] details=line.split(",");
				
				String id,fname,lname,address,gender,phone,email,username,password;
				id=details[0];
				fname=details[1];
				lname=details[2];
				address=details[3];
				gender=details[4];
				phone=details[5];
				email=details[6];
				username=details[7];
				password=details[8];
				
				
				Customer ent=new Customer(id,fname,lname,address,gender,phone,email,username,password);
				customerList.add(ent);
			}

			scan.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//loading accounts to accountList
		try {
			File file1=new File("src/accountlist.txt");
			Scanner scan1=new Scanner(file1);
		
			while(scan1.hasNextLine()) {
				String line=scan1.nextLine();
				String[] Bdetails=line.split(",");
				
				
				String id,accType,ownerID;
				id=Bdetails[0];
				accType=Bdetails[1];
				ownerID=Bdetails[2];
				double balance=Double.parseDouble(Bdetails[3]);
				
				BankAccount bank=new BankAccount(id,accType,ownerID);
				accountList.add(bank);
				bank.setBalance(balance);
			}

			scan1.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//loading deleted accounts to deletedAccList
		try {
			File file2=new File("src/deletedlist.txt");
			Scanner scan2=new Scanner(file2);
		
			while(scan2.hasNextLine()) {
				String line=scan2.nextLine();
				String[] Ddetails=line.split(",");
				
				
				String id,accType,ownerID;
				
				id=Ddetails[0];
				accType=Ddetails[1];
				ownerID=Ddetails[2];
				
				
				BankAccount bank=new BankAccount(id,accType,ownerID);
				deletedAccList.add(bank);
				
			}

			scan2.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//loading transactions 
		try {
			File file3=new File("src/transaction.txt");
			Scanner scan3=new Scanner(file3);
		
			while(scan3.hasNextLine()) {
				String tline=scan3.nextLine();
				transactions.add(tline);
				
			}
			scan3.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		//loading amountRecord 
		try {
			File file4=new File("src/amountRecord.txt");
			Scanner scan4=new Scanner(file4);
		
			while(scan4.hasNextLine()) {
				String aline=scan4.nextLine();
				amountRecord.add(aline);
				
			}

			scan4.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	
	}
	//this will save every element in the arraylists to the corresponding text files
	public static void write() {
		//saving customers into the file
		try {
			PrintWriter cusOutput=new PrintWriter(new FileWriter("src/customerlist.txt"));
			for(Customer cus:customerList) {
				String cLine=cus.getId()+","+cus.getFirstName()+","+cus.getLastName()+","+cus.getAddress()+","+cus.getGender()+","+cus.getPhone()+","+cus.getEmail()+","+cus.getUserName()+","+cus.getPassWord();
				cusOutput.println(cLine);
				}
			cusOutput.close();
			
			PrintWriter accOutput=new PrintWriter(new FileWriter("src/accountlist.txt"));
			for(BankAccount bank:accountList) {
				String aLine=bank.getAccID()+","+bank.getAccType()+","+bank.getOwnerID()+","+bank.getBalance();
				accOutput.println(aLine);
				}
			accOutput.close();
			
			PrintWriter delOutput=new PrintWriter(new FileWriter("src/deletedlist.txt"));
			for(BankAccount bank:deletedAccList) {
				String dLine=bank.getAccID()+","+bank.getAccType()+","+bank.getOwnerID();
				delOutput.println(dLine);
				}
			delOutput.close();
			
			PrintWriter transOutput=new PrintWriter(new FileWriter("src/transaction.txt"));
			for(String tLine:transactions) {
				transOutput.println(tLine);
				}
			transOutput.close();
			
			PrintWriter amtOutput=new PrintWriter(new FileWriter("src/amountRecord.txt"));
			for(String rLine:amountRecord) {
				amtOutput.println(rLine);
			}
			amtOutput.close();
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
