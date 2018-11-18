package Default;

import java.util.Scanner;
import Accounts.Account;
import Accounts.AccountsList;
import Accounts.Checking;
import Accounts.Savings;
import Customers.Customer;
import Customers.CustomersList;
import Exceptions.CompleteYourInfo;
import Transaction.Transaction;

public class Menu {
	
	String accountNumber;
	String ssn;

	Scanner keyRead = new Scanner(System.in);

	AccountsList myAccountList = new AccountsList();

	CustomersList clientList = new CustomersList();

	public static void main(String[] args) {

		
		
//		Menu menu = new Menu();
//		menu.printFirstMenu();
//		menu.performActionFirstMenu();

	}

	void printFirstMenu() {
		System.out.println("+----------------------------------------------+");
		System.out.println("|         Welcome to Malek's BankSystem        |");
		System.out.println("+----------------------------------------------+");
		System.out.println();
		System.out.println();

		System.out.println("1) Sign Up as new customer.");
		System.out.println("2) Sign in.");
		System.out.println("0) Exit.");
	}

	void performActionFirstMenu() {
		int choice;
		System.out.println();
		choice = getUserChoice();

		switch (choice) {
		case 0:
			System.out.println("Program finished, Thank you ");
			System.exit(0);
			break;
		case 1:
			signUpNewCustomer();

			break;
		case 2:
			signInCustomer();
			break;
		}
	}

	private void signInCustomer() {

		System.out.println("Enter your ssn: ");
		String ssn = keyRead.nextLine();
		boolean isExist = clientList.checkSsnExistance(ssn);
		if (isExist) {
			printSignedInUserMenu();
		}
		else 
			System.out.println("Wrong ssn!");
	}

	private void printSignedInUserMenu() {

		System.out.println("\n1)Make a deposit.");
		System.out.println("2)Make a withdrawl.");
		System.out.println("3)Make a Transaction.");
		System.out.println("4)Report.");
	}

	private void signUpNewCustomer() {

		System.out.println("We need some information to create a user account!\n");

		getNewCustomerInfo();

		printCreatAnAccount();

		performAccountChoice();

	}

	private void getNewCustomerInfo() {

		System.out.println("Enter your name: ");

		String name = keyRead.nextLine();

		System.out.println("Enter your address: ");
		String address = keyRead.nextLine();

		System.out.println("Enter your social security number: ");
		String ssn = keyRead.nextLine();

		Customer newCustomer = new Customer(name, address, ssn);
		clientList.addNewCustomer(newCustomer);

		System.out.println("Welcome " + name + " !\n\n");
	}

	void printCreatAnAccount() {
		System.out.println("1) Create a new bank account.");
		System.out.println("2) Connect to an exist bank account.");

	}

	int getUserChoice() {
		System.out.println("\nEnter your choice here:");
		int choice = Integer.parseInt(keyRead.nextLine());

		return choice;

	}

	void performAccountChoice() {
		int choice = getUserChoice();
		switch (choice) {
		case 1:
			createANewAccount();

			break;
		case 2:

			connectToAnExistAccount();
			break;

		}

	}

	private void connectToAnExistAccount() {

	}

	private void createANewAccount() {

		System.out.println("Choose the type of the account (saving or checking): ");
		System.out.println("1) Saving Account.");
		System.out.println("2) Checking Account.");
		int choice = getUserChoice();

		Account account = new Account();

		if (choice == 1) {
			account = new Savings();
			myAccountList.addNewAccount(account);
		} else if (choice == 2) {
			account = new Checking();
			myAccountList.addNewAccount(account);
		}

		System.out.println(myAccountList.toString());

	}

}
