/**
 * Just like last time, the ATM class is responsible for managing all
 * of the user interaction. This means login procedures, displaying the
 * menu, and responding to menu selections. In the enhanced version, the
 * ATM class will have the added responsibility of interfacing with the
 * Database class to write and read information to and from the database.
 * 
 * Most of the functionality for this class should have already been
 * implemented last time. You can always reference my Github repository
 * for inspiration (https://github.com/rwilson-ucvts/java-sample-atm).
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedWriter;

public class ATM extends Database{
	
	public ATM(String[] accounts, FileReader fr, BufferedReader br, BufferedWriter writer, float balance, long accountNum, float withdraw, float deposit, int pin, String DOB, int phoneNum, String fName, String lName, String address, String city, String state, int zipCode) {
		super(accounts, fr, br, writer, balance, accountNum, withdraw, deposit, pin, DOB, phoneNum, fName, lName, address, city, state, zipCode);
	}

	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		//account
		//validate (login)
		//dispense
		//menu
		//deposit
		//withdraw
		//show balance
		
		menu();
		in.close();
	}
	//menu
	public static void menu() {
		User.setName();
		System.out.println("\nHello, " + getName() + ".\n");
		System.out.println("Please enter account number.");
		long tempNum = in.nextLong();
		if (Database.checkAccountNum(User.getLName(), tempNum) == true) {
			System.out.println("Please enter pin.");
			int tempPin = in.nextInt();
			if (Database.checkPin(User.getLName(), tempPin) == true) {
				System.out.println("Login Success...");
				System.out.println("\nWhat do you want to do?");
				Database.getOriginalBalance(getLName(), tempNum);
				char choice = 'z';

				in.nextLine();
				Database.printFile();
				
				while(choice != 'e') {
					System.out.println("\nEnter 'd' to deposit. Enter 'w' to withdraw. Enter 'b' to show balance. Enter 't' to transfer.\nEnter 'p' to view personal info. Enter 'u' to update info. Enter 'e' to exit.");
					String temp = in.nextLine();
					choice = temp.charAt(0); 
					switch (choice) {
					case 'd':
						BankAccount.setDeposit();
						break;
					case 'p':
						Database.showInfo();
						break;
					case 'w':
						BankAccount.setWithdraw();
						break;
					case 't':
						Database.transfer();
						break;
					case 'b':
						System.out.println(BankAccount.getBalance());
						break;
					case 'u':
						Database.updateInfo();
						break;
					case 'e':
						System.out.println("\nHave a good day, " + getFName() + ".");
						break;
					default:
						System.out.print("Please enter valid command.");
					} 
				}
			}
			else {
				System.out.println("Incorrect pin. Please restart Transaction.");
			}
		}
		else {
			System.out.println("Name and account number do not match.");
		}
	}
}