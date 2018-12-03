/**
 * Just like last time, the User class is responsible for retrieving
 * (i.e., getting), and updating (i.e., setting) user information.
 * This time, though, you'll need to add the ability to update user
 * information and display that information in a formatted manner.
 * 
 * Most of the functionality for this class should have already been
 * implemented last time. You can always reference my Github repository
 * for inspiration (https://github.com/rwilson-ucvts/java-sample-atm).
 */

import java.util.Scanner;

public class User {
	//pin
	//phone #
	//name 
	//ssn
	//address
	static Scanner in = new Scanner(System.in);
	private static int pin = 0;
	private static int phoneNum;
	private static String DOB;
	private static String fName;
	private static String lName;
	private static String address;
	private static String city;
	private static String state;
	private static int zipCode;
	
	public User(int pin, String DOB, int phoneNum, String fName, String lName, String address, String city, String state, int zipCode) {
		
	}
	
	
	// update
	public static void updatePin() {
		System.out.println("\nEnter current pin.");
		int temp = 0;
		while (temp != pin) {
			temp = in.nextInt();
			if (temp == pin) {
				System.out.println("\nEnter new pin.");
				pin = in.nextInt();
			}
			else {
				System.out.println("\nIncorrect pin. Try again.");
			}
		}
	}
	public static void updatePhoneNum() {
		System.out.println("\nEnter new phone number.");
		phoneNum = in.nextInt();
	}
	public static void updateAddress() {
		System.out.println("Please enter street address.");
		address = in.nextLine();
		System.out.println("Please enter city.");
		city = in.nextLine();
		System.out.println("Please enter state.");
		state = in.nextLine();
		System.out.println("Please enter postal code.");
		zipCode = in.nextInt();
	}
	
	//setters
	public static boolean checkPin(int x) {
		if (Integer.toString(x).length() != 4) {
			return false;
		}
		else if (x != 0){
			return true;
		}
		else {
			return false;
		}
	}
	public static void setName() {
		System.out.println("Please enter name.");
		String name;
		name = in.nextLine();
		char target = ' ';
		for(int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == target) {
				lName = name.substring((i + 1), name.length());
				fName = name.substring(0, i);
			}
		}
	}
	public static void setPin() {
		System.out.println("Please enter pin.");
		pin = in.nextInt();
	}
	
	//getters
	public static String getName() {
		String name = fName + " " + lName;
		return name;
	}
	public static String getFName() {
		return fName;
	}
	public static String getLName() {
		return lName;
	}
	public static int getPin() {
		return pin;
	}
	public static String getDOB() {
		return DOB;
	}
	public static String getAddress() {
		return address;
	}
	public static String getCity() {
		return city;
	}
	public static String getState() {
		return state;
	}
	public static int getZipCode() {
		return zipCode;
	}
}