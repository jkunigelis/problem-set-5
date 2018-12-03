import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;

/**
 * This class has only one responsibility: start the ATM program!
 */

public class Tester extends ATM {
	
	/**
	 * Main method.
	 * 
	 * @param args
	 */
	public Tester(FileReader fr, BufferedReader br, BufferedWriter writer, float balance, long accountNum, float withdraw, float deposit, int pin, String DOB, int phoneNum, String fName, String lName, String address, String city, String state, int zipCode) {
		super(fr, br, writer, balance, accountNum, withdraw, deposit, pin, DOB, phoneNum, fName, lName, address, city, state, zipCode);
	}
	public static void main(String[] args) {
		/*
		 * Rather than hard coding one or more BankAccount objects, you'll need to read them in
		 * from our very primitive database (i.e., a flat-file). After making changes, of course,
		 * you'll need to update the database accordingly.
		 */
	}
}