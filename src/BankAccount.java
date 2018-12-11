/**
 * Just like last time, the BankAccount class is primarily responsible
 * for depositing and withdrawing money. In the enhanced version, there
 * will be the added requirement of transfering funds between accounts.
 * 
 * Most of the functionality for this class should have already been
 * implemented last time. You can always reference my Github repository
 * for inspiration (https://github.com/rwilson-ucvts/java-sample-atm).
 */

import java.util.Scanner;


public class BankAccount extends User {
	

	private static float balance;
	private static long accountNum = 0;
	private static float withdraw;
	private static float deposit;
	
	public BankAccount(float balance, long accountNum, float withdraw, float deposit, int pin, String DOB, int phoneNum, String lName, String fName, String address, String city, String state, int zipCode) {
		super(pin, DOB, phoneNum, fName, lName, address, city, state, zipCode);
		BankAccount.balance = balance;
		BankAccount.accountNum = accountNum;
		BankAccount.withdraw = withdraw;
		BankAccount.deposit = deposit;
	}
	static Scanner in = new Scanner(System.in);
	//balance
	//account num
	//account owner
	//withdraw
	//deposit
	
	
	
 	public static float setDeposit() {
		System.out.println("Enter amount to deposit.");
		deposit = in.nextFloat();
		if (deposit < 0) {
			System.out.println("Not valid amount.");
		}
		else {
			balance = balance + deposit;
		}
		return balance;
	}
	public static float setWithdraw() {
		System.out.println("Enter amount to withdraw.");
		withdraw = in.nextFloat();
		if (withdraw < 0) {
			System.out.println("Not valid amount.");
		}
		else if (withdraw > balance) {
			System.out.println("Not valid amount.");
		}
		else {
			balance = balance - withdraw;
		}
		return balance;
	}
	public static float withdraw(float x) {
		withdraw = x;
		if (withdraw < 0) {
			System.out.println("Not valid amount.");
		}
		else if (withdraw > balance) {
			System.out.println("Not valid amount.");
		}
		else {
			balance = balance - withdraw;
		}
		return balance;
	}
	public static long getAccountNum () {
		return accountNum;
	}
	public static void setAccountNum (long x) {
		accountNum = x;
	}
	public static void setOriginalBalance(float f) {
		balance = f;
	}
	public static float getBalance() {
		return balance;
	}
}
