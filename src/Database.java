import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * This class will serve as the intermediary between our ATM program and
 * the database of BankAccounts. It'll be responsible for fetching accounts
 * when users try to login, as well as updating those accounts after any
 * changes are made.
 */


public class Database extends BankAccount {
	private static String[] accounts;
	private static FileReader fr = null;
	private static BufferedReader br = null;
	private static BufferedWriter writer = null;
	
	public Database(String[] accounts, FileReader fr, BufferedReader br, BufferedWriter writer, float balance, long accountNum, float withdraw, float deposit, int pin, String DOB, int phoneNum, String lName, String fName, String address, String city, String state, int zipCode) {
		super(balance, accountNum, withdraw, deposit, pin, DOB, phoneNum, fName, lName, address, city, state, zipCode);
	}
	
	
	public static void updateInfo() {
		System.out.println("What do you want to update? 'p' for pin. 'n' for phone number. 'a' for address. 'e' to exit.");
		String temp5 = in.nextLine();
		switch (temp5) {
		case "p":
			Database.updatePin();
			break;
		case "n":
			Database.updatePhoneNum();
			break;
		case "a":
			Database.updateAddress();
			break;
		case "e":
			break;
		default:
			System.out.println("Enter valid command.");
		}
	}
	public static void updatePin() {
		System.out.println("Please enter current pin.");
		int temp3 = in.nextInt();
		boolean isValid = Database.checkPin(User.getLName(), temp3);
		if (isValid == true) {
			System.out.println("Please enter new pin.");
			int newPin = in.nextInt();
			if (User.checkPin(newPin) == true) {
				try {
					fr = new FileReader("src\\accounts-db.txt");
					writer = new BufferedWriter(new FileWriter("src\\accounts-db.txt"));
					br = new BufferedReader(fr);
					String line;
					while(br.ready() == true) {
						line = br.readLine();
						if (line.contains(User.getLName())) {
									// alternative?
							// String output = Long.toString(Database.getAccountNum(User.getLName())) + Integer.toString(newPin) + Float.toString(BankAccount.getBalance()) + Database.getName(Database.getAccountNum(User.getLName())) + Database.getUnformattedDOB() + Database.getUnformattedPhoneNum() + Database.getAddress();
							// String output = line.substring(0, 9) + Integer.toString(newPin) + line.substring(13, 146);
							// writer.write(output);
							for (String acct : accounts) {
								writer.write(acct);
								writer.newLine();
							}
						}
						else {
							writer.write(line);
						} 
					}
				}
				catch (FileNotFoundException e) {
					System.out.println("File not found.");
				}
				catch (IOException e) {
					System.out.println("Cannot read file!");
				}
				finally {
					if (br != null) {
						try {
							br.close();
						}
						catch (IOException e) { 
							/* ensure close */ 
						}
					}
					if (fr != null) {
						try {
							fr.close();
						}
						catch (IOException e) { 
							/* ensure close */ 
						}
					}
					if (writer != null) {
						try {
							writer.close();
						}
						catch (IOException e) { 
							/* ensure close */ 
						}
					}
				}
			}
			else {
				System.out.println("Not valid pin.");
			}
		}
		else {
			System.out.println("Incorrect pin.");
		}
	}
	public static void showInfo() {
		System.out.println("\nName:" + User.getFName() + " " + User.getLName() + "\n");
		System.out.println("Date of Birth: " + Database.getDOB());
		System.out.println("Phone Number: " + Database.getPhoneNum());
		System.out.println("Address: " + Database.getAddress());
	}
	public static String getAddress() {
		String tempAddress = null;
		try {
			fr = new FileReader("src\\accounts-db.txt");
			br = new BufferedReader(fr);
			String line;
			while(br.ready() == true) {
				line = br.readLine();
				if (line.contains(User.getLName())) {
					tempAddress = line.substring(81, 148);
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		catch (IOException e) {
			System.out.println("Cannot read file!");
		}
		finally {
			if (br != null) {
				try {
					br.close();
				}
				catch (IOException e) { 
					/* ensure close */ 
				}
			}
			if (fr != null) {
				try {
					fr.close();
				}
				catch (IOException e) { 
					/* ensure close */ 
				}
			}
		}
		if (tempAddress == null) {
			return null;
		}
		else {
			return tempAddress;
		}
	}
	public static String getPinForUp() {
		String tempPin = null;
		try {
			fr = new FileReader("src\\accounts-db.txt");
			br = new BufferedReader(fr);
			String line;
			while(br.ready() == true) {
				line = br.readLine();
				if (line.contains(User.getLName())) {
					tempPin = line.substring(9, 13);
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		catch (IOException e) {
			System.out.println("Cannot read file!");
		}
		finally {
			if (br != null) {
				try {
					br.close();
				}
				catch (IOException e) { 
					/* ensure close */ 
				}
			}
			if (fr != null) {
				try {
					fr.close();
				}
				catch (IOException e) { 
					/* ensure close */ 
				}
			}
		}
		if (tempPin == null) {
			return null;
		}
		else {
			return tempPin;
		}
	}
	public static String getPhoneNum() {
		String tempPhone = null;
		try {
			fr = new FileReader("src\\accounts-db.txt");
			br = new BufferedReader(fr);
			String line;
			while(br.ready() == true) {
				line = br.readLine();
				if (line.contains(User.getLName())) {
					tempPhone = line.substring(71, 74) + "-" + line.substring(74, 77) + "-" + line.substring(77, 81);
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		catch (IOException e) {
			System.out.println("Cannot read file!");
		}
		finally {
			if (br != null) {
				try {
					br.close();
				}
				catch (IOException e) { 
					/* ensure close */ 
				}
			}
			if (fr != null) {
				try {
					fr.close();
				}
				catch (IOException e) { 
					/* ensure close */ 
				}
			}
		}
		if (tempPhone == null) {
			return null;
		}
		else {
			return tempPhone;
		}
	}
	public static String getUnformattedPhoneNum() {
		String tempPhone = null;
		try {
			fr = new FileReader("src\\accounts-db.txt");
			br = new BufferedReader(fr);
			String line;
			while(br.ready() == true) {
				line = br.readLine();
				if (line.contains(User.getLName())) {
					tempPhone = line.substring(71, 81);
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		catch (IOException e) {
			System.out.println("Cannot read file!");
		}
		finally {
			if (br != null) {
				try {
					br.close();
				}
				catch (IOException e) { 
					/* ensure close */ 
				}
			}
			if (fr != null) {
				try {
					fr.close();
				}
				catch (IOException e) { 
					/* ensure close */ 
				}
			}
		}
		if (tempPhone == null) {
			return null;
		}
		else {
			return tempPhone;
		}
	}
	public static String getDOB() {
		String tempDOB = null;
		try {
			fr = new FileReader("src\\accounts-db.txt");
			br = new BufferedReader(fr);
			String line;
			while(br.ready() == true) {
				line = br.readLine();
				if (line.contains(User.getLName())) {
					tempDOB = line.substring(67, 69) + "-" + line.substring(69, 71) + "-" + line.substring(63, 67);
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		catch (IOException e) {
			System.out.println("Cannot read file!");
		}
		finally {
			if (br != null) {
				try {
					br.close();
				}
				catch (IOException e) { 
					/* ensure close */ 
				}
			}
			if (fr != null) {
				try {
					fr.close();
				}
				catch (IOException e) { 
					/* ensure close */ 
				}
			}
		}
		if (tempDOB == null) {
			return null;
		}
		else {
			return tempDOB;
		}
	}
	public static String getUnformattedDOB() {
		String tempDOB = null;
		try {
			fr = new FileReader("src\\accounts-db.txt");
			br = new BufferedReader(fr);
			String line;
			while(br.ready() == true) {
				line = br.readLine();
				if (line.contains(User.getLName())) {
					tempDOB = line.substring(63, 67) + line.substring(67, 69) + line.substring(69, 71);
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		catch (IOException e) {
			System.out.println("Cannot read file!");
		}
		finally {
			if (br != null) {
				try {
					br.close();
				}
				catch (IOException e) { 
					/* ensure close */ 
				}
			}
			if (fr != null) {
				try {
					fr.close();
				}
				catch (IOException e) { 
					/* ensure close */ 
				}
			}
		}
		if (tempDOB == null) {
			return null;
		}
		else {
			return tempDOB;
		}
	}
	public static boolean checkPin(String str, int x) {
		int count = 0;
		try {
			fr = new FileReader("src\\accounts-db.txt");
			br = new BufferedReader(fr);
			String line;
			while(br.ready() == true) {
				line = br.readLine();
				if (line.contains(str)) {
					if (line.substring(9, 13).equals(String.valueOf(x))) {
							count++;
					}
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		catch (IOException e) {
			System.out.println("Cannot read file!");
		}
		finally {
			if (br != null) {
				try {
					br.close();
				}
				catch (IOException e) { 
					/* ensure close */ 
				}
			}
			if (fr != null) {
				try {
					fr.close();
				}
				catch (IOException e) { 
					/* ensure close */ 
				}
			}
		}
		if (count == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	public static boolean checkAccountNum(String str, long x) {
		int count = 0;
		try {
			fr = new FileReader("src\\accounts-db.txt");
			br = new BufferedReader(fr);
			String line;
			while(br.ready() == true) {
				line = br.readLine();
				if (line.contains(str)) {
					if (line.substring(0, 9).equals(String.valueOf(x))) {
							count++;
					}
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		catch (IOException e) {
			System.out.println("Cannot read file!");
		}
		finally {
			if (br != null) {
				try {
					br.close();
				}
				catch (IOException e) { 
					/* ensure close */ 
				}
			}
			if (fr != null) {
				try {
					fr.close();
				}
				catch (IOException e) { 
					/* ensure close */ 
				}
			}
		}
		if (count == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	public static String getName(long x) {
		// x being accountNum
		// returns name
		String name = null;
				try {
					fr = new FileReader("src\\accounts-db.txt");
					br = new BufferedReader(fr);
					String line;
					while(br.ready() == true) {
						line = br.readLine();
						if (Long.parseLong(line.substring(0, 9)) == x) {
							name = line.substring(48, 63) + " " + line.substring(28, 48);
						}
					}
				}
				catch (FileNotFoundException e) {
					System.out.println("File not found.");
				}
				catch (IOException e) {
					System.out.println("Cannot read file!");
				}
				finally {
					if (br != null) {
						try {
							br.close();
						}
						catch (IOException e) { 
							/* ensure close */ 
						}
					}
					if (fr != null) {
						try {
							fr.close();
						}
						catch (IOException e) { 
							/* ensure close */ 
						}
					}
				}
				if (name == null) {
					return null;
				}
				else {
					return name;
				}
	}
	public static long getAccountNum(String str) {
		// str being the last name of the person
		int count = 0;
		long num = 0;
				try {
					fr = new FileReader("src\\accounts-db.txt");
					br = new BufferedReader(fr);
					String line;
					while(br.ready() == true) {
						line = br.readLine();
						if (line.substring(29, (29 + str.length())) == str) {
							count++;
							num = Long.parseLong(line.substring(0, 9));
						}
					}
				}
				catch (FileNotFoundException e) {
					System.out.println("File not found.");
				}
				catch (IOException e) {
					System.out.println("Cannot read file!");
				}
				finally {
					if (br != null) {
						try {
							br.close();
						}
						catch (IOException e) { 
						}
					}
					if (fr != null) {
						try {
							fr.close();
						}
						catch (IOException e) { 
						}
					}
				}
				if (count == 0) {
					return 0;
				}
				else {
					return num;
				}
				
	}
	public static void transfer() {
		System.out.println("Enter account number of person.");
		long temp = in.nextLong();
		String choice = "z";
		in.nextLine();
		if (checkAccountNumTrans(temp) == true) {
			System.out.println("Are you sure you want to transfer funds to " + Database.getName(temp) + "? Enter 'y' or 'n'.");
			choice = in.nextLine();
			switch (choice) {
			case "y":
				System.out.println("Enter amount to transfer.");
				float transfer = in.nextFloat();
				if (transfer < 0) {
					System.out.println("Not valid amount.");
				}
				else if (transfer > BankAccount.getBalance()) {
					System.out.println("Not valid amount.");
				}
				else if (transfer > 0 && transfer <= BankAccount.getBalance()) {
					BankAccount.withdraw(transfer);
					//increase other account balance
					System.out.println("Transfer complete.");
				}
				break;
			case "n":
				break;
			default:
				System.out.println("Command invalid.");
			}
		}
		else {
			System.out.println("Not valid account number.");
		}
	}
	public static boolean checkAccountNumTrans(long x) {
		int count = 0;
		try {
			fr = new FileReader("src\\accounts-db.txt");
			br = new BufferedReader(fr);
			String line;
			while(br.ready() == true) {
				line = br.readLine();
				if (line.substring(0, 9).equals(String.valueOf(x)) && line.endsWith("Y")) {
						count++;
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		catch (IOException e) {
			System.out.println("Cannot read file!");
		}
		finally {
			if (br != null) {
				try {
					br.close();
				}
				catch (IOException e) { 
					/* ensure close */ 
				}
			}
			if (fr != null) {
				try {
					fr.close();
				}
				catch (IOException e) { 
					/* ensure close */ 
				}
			}
		}
		if (count == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	public static void getOriginalBalance(String str, long x) {
		try {
			fr = new FileReader("src\\accounts-db.txt");
			br = new BufferedReader(fr);
			String line;
			while(br.ready() == true) {
				line = br.readLine();
				if (line.contains(str)) {
					if (line.substring(0, 9).equals(String.valueOf(x))) {
						setOriginalBalance(Float.parseFloat(line.substring(13, 28)));
					}
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		catch (IOException e) {
			System.out.println("Cannot read file!");
		}
		finally {
			if (br != null) {
				try {
					br.close();
				}
				catch (IOException e) { 
				}
			}
			if (fr != null) {
				try {
					fr.close();
				}
				catch (IOException e) { 
				}
			}
		}
	}
	/* public static void setBalance(String str) {
		// str being the last name of the person
		try {
			fr = new FileReader("src\\accounts-db.txt");
			br = new BufferedReader(fr);
			String line;
			while(br.ready() == true) {
				line = br.readLine();
				if (line.substring(29, (29 + str.length())) == str) {
					BankAccount.setBalance(Integer.parseInt(line.substring(14, (14 + 15))));
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		catch (IOException e) {
			System.out.println("Cannot read file!");
		}
		finally {
			if (br != null) {
				try {
					br.close();
				}
				catch (IOException e) {
				}
			} 
			if (fr != null) {
				try {
					fr.close();
				}
				catch (IOException e) { 
				}
			}
		}
		
	} */
	public static void printFile() {
		int count = 0;
		String[] accounts = new String[10];
		try {
			String line = null;
			fr = new FileReader("src\\accounts-db.txt");
			br = new BufferedReader(fr);
			while(br.ready() == true) {
				// print line
				if (count >= accounts.length) {
					accounts = Arrays.copyOf(accounts, accounts.length + 10);
				}
				accounts[count++] = line;
				br.readLine();
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		catch (IOException e) {
			System.out.println("Cannot read file!");
		}
		finally {
			if (br != null) {
				try {
					br.close();
				}
				catch (IOException e) { 
					/* ensure close */ 
				}
			}
			if (fr != null) {
				try {
					fr.close();
				}
				catch (IOException e) { 
					/* ensure close */ 
				}
			}
		}
	}
}