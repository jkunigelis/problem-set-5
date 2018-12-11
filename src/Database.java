import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class will serve as the intermediary between our ATM program and
 * the database of BankAccounts. It'll be responsible for fetching accounts
 * when users try to login, as well as updating those accounts after any
 * changes are made.
 */


public class Database extends BankAccount {
	private static String[] accounts = null;
	private static FileReader fr = null;
	private static BufferedReader br = null;
	private static BufferedWriter writer = null;
	
	public Database(String[] accounts, FileReader fr, BufferedReader br, BufferedWriter writer, float balance, long accountNum, float withdraw, float deposit, int pin, String DOB, int phoneNum, String lName, String fName, String address, String city, String state, int zipCode) {
		super(balance, accountNum, withdraw, deposit, pin, DOB, phoneNum, fName, lName, address, city, state, zipCode);
		Database.accounts = accounts;
		Database.fr = fr;
		Database.br = br;
		Database.writer = writer;
	}
	
	public static void deactivate() {
		System.out.println("Are you sure you want to deactivate your account? Enter 'y' or 'n'.");
		String temp = in.nextLine();
		char choice = temp.charAt(0);
		switch (choice) {
		case 'n':
			break;
		case 'y':
			try {
				fr = new FileReader("src\\accounts-db.txt");
				br = new BufferedReader(fr);
				String line;
				for (int i = 0; i < accounts.length; i++) {
					line = br.readLine();
					if (line.contains(User.getLName())) {
						accounts[i] = line.substring(0, 145) + "N";
					}
				}
				writer = new BufferedWriter(new FileWriter("src\\accounts-db.txt"));
				for(int i = 0; i < accounts.length; i++) {
					if (i == (accounts.length - 1)) {
						writer.write(accounts[i]);
					}
					else {
						writer.write(accounts[i]);
						writer.newLine();
					}
				}
				writer.flush();
				writer.close();
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
			System.out.println("Account deactivated.");
		default:
			break;
		}
	}
	
	public static void updateWithdrawDeposit(float x) {
		String y = Float.toString(x);
		int count = 0;
		for (int i = 0; i < y.length(); i++) {
			if (y.substring(i, (i + 1)).equals(".")) {
				for (int j = 0; j < y.length(); j++) {
					count++;
				}
			}
		}
		if (count == 1) {
			y = y + "0";
		}
		else if (count == 0) {
			y = y + ".00";
		}
		/*for (int i = 0; i < y.length(); i++) {
			if (y.substring(i, (i + 1)).equals(".")) {
				y = y.substring(0, (i + 2));
			}
		} */
		while (y.length() != 15) {
			y = y + " ";
		}
		
			try {
				fr = new FileReader("src\\accounts-db.txt");
				br = new BufferedReader(fr);
				String line;
				for (int i = 0; i < accounts.length; i++) {
					line = br.readLine();
					if (line.contains(Long.toString(BankAccount.getAccountNum()))) {
						accounts[i] = line.substring(0, 13) + y + line.substring(28, 146);
					}
				}
				writer = new BufferedWriter(new FileWriter("src\\accounts-db.txt"));
				for(int i = 0; i < accounts.length; i++) {
					if (i == (accounts.length - 1)) {
						writer.write(accounts[i]);
					}
					else {
						writer.write(accounts[i]);
						writer.newLine();
					}
				}
				writer.flush();
				writer.close();
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
	public static void updateWithdrawDepositTrans(float x, long a) {
		String y = Float.toString(x);
		int count = 0;
		for (int i = 0; i < y.length(); i++) {
			if (y.substring(i, (i + 1)).equals(".")) {
				for (int j = 0; j < y.length(); j++) {
					count++;
				}
			}
		}
		if (count == 1) {
			y = y + "0";
		}
		else if (count == 0) {
			y = y + ".00";
		}
		/*for (int i = 0; i < y.length(); i++) {
			if (y.substring(i, (i + 1)).equals(".")) {
				y = y.substring(0, (i + 2));
			}
		} */
		while (y.length() != 15) {
			y = y + " ";
		}
		
			try {
				fr = new FileReader("src\\accounts-db.txt");
				br = new BufferedReader(fr);
				String line;
				for (int i = 0; i < accounts.length; i++) {
					line = br.readLine();
					if (line.contains(Long.toString(a))) {
						accounts[i] = line.substring(0, 13) + y + line.substring(28, 146);
					}
				}
				writer = new BufferedWriter(new FileWriter("src\\accounts-db.txt"));
				for(int i = 0; i < accounts.length; i++) {
					if (i == (accounts.length - 1)) {
						writer.write(accounts[i]);
					}
					else {
						writer.write(accounts[i]);
						writer.newLine();
					}
				}
				writer.flush();
				writer.close();
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
	public static void createAccount() {
		long tempAccountNumNew = 100000001;
		while (checkAccountNumTaken(tempAccountNumNew) == true) {
			tempAccountNumNew++;
		}
		String accountNumNew = Long.toString(tempAccountNumNew);
		System.out.println("Enter the pin you want.");
		int tempPinNew = in.nextInt();
		if (String.valueOf(tempPinNew).length() == 4) {
			String pinNew = String.valueOf(tempPinNew);
			in.nextLine();
			System.out.println("\nEnter year of birth.");
			String year = in.nextLine();
			if (year.length() == 4) {
				System.out.println("\nEnter month of birth. (Ex. January --> '01' December --> '12')");
				String month = in.nextLine();
				if (month.length() == 2) {
					System.out.println("\nEnter day of birth.");
					String day = in.nextLine();
					String unformattedDOB = year + month + day;
					System.out.println("\nEnter phone number. (Ex. 5559993333)");
					String unformattedPhoneNum = in.nextLine();
					if (unformattedPhoneNum.length() == 10) {
						System.out.println("\nPlease enter street address. (Ex. \"123 Main Street\"))");
						String tempStreet = in.nextLine();
						System.out.println("\nPlease enter city.");
						String tempCity = in.nextLine();
						System.out.println("\nPlease enter state abbreviation.");
						String tempState = in.nextLine();
						System.out.println("\nPlease enter zip code.");
						String tempZipCode = in.nextLine();
						while (tempStreet.length() != 30) {
							tempStreet = tempStreet + " ";
						}
						while (tempCity.length() != 30) {
							tempCity = tempCity + " ";
						}
						String unformattedAddress = tempStreet + tempCity + tempState + tempZipCode;
						String newName = User.getLName() + ", " + User.getFName();
						while (newName.length() != 32) {
							newName = newName + " ";
						}
						try {
							fr = new FileReader("src\\accounts-db.txt");
							br = new BufferedReader(fr);
							writer = new BufferedWriter(new FileWriter("src\\accounts-db.txt"));
							String output = accountNumNew + pinNew + "0.00           " + newName + unformattedDOB + unformattedPhoneNum + unformattedAddress + "Y";
							for(int i = 0; i < (accounts.length + 1); i++) {
								if (i == (accounts.length)) {
									writer.write(output);
								}
								else {
									writer.write(accounts[i]);
									writer.newLine();
								}
							}
							writer.flush();
							writer.close();
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
						System.out.println("Account created.");
					}
					else {
						System.out.println("Not valid phone number.");
					}
				}
				else {
					System.out.println("Not valid month.");
				}
			}
			else {
				System.out.println("Not valid year.");
			}
		}
		else {
			System.out.println("Not valid pin.");
		}
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
	public static void updatePhoneNum() {
			System.out.println("Please enter new phone number. (Ex. '5557775555'))");
			String newNum = in.nextLine();
				try {
					fr = new FileReader("src\\accounts-db.txt");
					br = new BufferedReader(fr);
					String line;
					for (int i = 0; i < accounts.length; i++) {
						line = br.readLine();
						if (line.contains(User.getLName())) {
							accounts[i] = line.substring(0, 67) + newNum + line.substring(67, (line.length() - 1));
						}
					}
					writer = new BufferedWriter(new FileWriter("src\\accounts-db.txt"));
					for(int i = 0; i < accounts.length; i++) {
						if (i == (accounts.length - 1)) {
							writer.write(accounts[i]);
						}
						else {
							writer.write(accounts[i]);
							writer.newLine();
						}
					}
					writer.flush();
					writer.close();
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
	public static void updatePin() {
		System.out.println("Please enter current pin.");
		int temp3 = in.nextInt();
		in.nextLine();
		boolean isValid = Database.checkPin(User.getLName(), temp3);
		if (isValid == true) {
			System.out.println("Please enter new pin.");
			int newPin = in.nextInt();
			if (User.checkPin(newPin) == true) {
				try {
					fr = new FileReader("src\\accounts-db.txt");
					br = new BufferedReader(fr);
					String line;
					for (int i = 0; i < accounts.length; i++) {
						line = br.readLine();
						if (line.contains(User.getLName())) {
							accounts[i] = line.substring(0, 9) + Integer.toString(newPin) + line.substring(13, (line.length() - 1));
						}
					}
					writer = new BufferedWriter(new FileWriter("src\\accounts-db.txt"));
					for(int i = 0; i < accounts.length; i++) {
						if (i == (accounts.length - 1)) {
							writer.write(accounts[i]);
						}
						else {
							writer.write(accounts[i]);
							writer.newLine();
						}
					}
					writer.flush();
					writer.close();
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
	public static void updateAddress() {
			System.out.println("Please enter new street address. (Ex. \"123 Main Street\"))");
			String tempStreet = in.nextLine();
			System.out.println("Please enter new city.");
			String tempCity = in.nextLine();
			System.out.println("Please enter new state abbreviation.");
			String tempState = in.nextLine();
			System.out.println("Please enter new zip code.");
			String tempZipCode = in.nextLine();
			while (tempStreet.length() != 30) {
				tempStreet = tempStreet + " ";
			}
			while (tempCity.length() != 30) {
				tempCity = tempCity + " ";
			}
			String unformattedAddress = tempStreet + tempCity + tempState + tempZipCode;
			try {
				fr = new FileReader("src\\accounts-db.txt");
				br = new BufferedReader(fr);
				String line;
				for (int i = 0; i < accounts.length; i++) {
					line = br.readLine();
					if (line.contains(User.getLName())) {
						accounts[i] = line.substring(0, 78) + unformattedAddress + line.substring(145);
					}
				}
				writer = new BufferedWriter(new FileWriter("src\\accounts-db.txt"));
				for(int i = 0; i < accounts.length; i++) {
					if (i == (accounts.length - 1)) {
						writer.write(accounts[i]);
					}
					else {
						writer.write(accounts[i]);
						writer.newLine();
					}
				}
				writer.flush();
				writer.close();
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
	public static void showInfo() {
		System.out.println("\nName:" + User.getFName() + " " + User.getLName() + "\n");
		System.out.println("Date of Birth: " + Database.getDOB());
		System.out.println("Phone Number: " + Database.getPhoneNum());
		System.out.println("Address: " + Database.getAddress().substring(0, 30) +"\nCity: " + Database.getAddress().substring(30, 60) + "\nState: " + Database.getAddress().substring(60, 62) + "\nZip Code: " + Database.getAddress().substring(62, 67));
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
					tempAddress = line.substring(78, 146);
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
	public static String getPhoneNum() {
		String tempPhone = null;
		try {
			fr = new FileReader("src\\accounts-db.txt");
			br = new BufferedReader(fr);
			String line;
			while(br.ready() == true) {
				line = br.readLine();
				if (line.contains(User.getLName())) {
					tempPhone = line.substring(68, 71) + "-" + line.substring(71, 74) + "-" + line.substring(74, 78);
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
					tempDOB = line.substring(64, 66) + "-" + line.substring(66, 68) + "-" + line.substring(60, 64);
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
			BankAccount.setAccountNum(x);;
			return true;
		}
	}
	public static boolean checkAccountNumTaken(long x) {
		int count = 0;
		try {
			fr = new FileReader("src\\accounts-db.txt");
			br = new BufferedReader(fr);
			String line;
			while(br.ready() == true) {
				line = br.readLine();
					if (line.substring(0, 9).equals(String.valueOf(x))) {
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
	public static float findAccountBalance(long x) {
		String otherBalance = null;
		for(int i = 0; i < accounts.length; i++) {
			if (accounts[i].contains(Long.toString(x)) == true) {
				String line = accounts[i];
				otherBalance = line.substring(13, 28);
			}
		}
		float temptemp = Float.parseFloat(otherBalance);
		return temptemp;
	}
	public static void transfer() {
		float otherBalance;
		System.out.println("Enter account number of person.");
		long temp = in.nextLong();
		in.nextLine();
		if (checkAccountNumTrans(temp) == true) {
				System.out.println("Enter amount to transfer.");
				float transfer = in.nextFloat();
				if (transfer < 0) {
					System.out.println("Not valid amount.");
				}
				else if (transfer > BankAccount.getBalance()) {
					System.out.println("Not valid amount.");
				}
				else if (transfer > 0 && transfer <= BankAccount.getBalance()) {
					
					float temp56 = BankAccount.withdraw(transfer);
					Database.updateWithdrawDeposit(temp56);
					//increase other account balance
					
					
					otherBalance = Database.findAccountBalance(temp);
					otherBalance = otherBalance + transfer;
					
					Database.updateWithdrawDepositTrans(otherBalance, temp);
							
					System.out.println("Transfer complete.");
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
	public static int countLines() {
		int count = 0;
		try {
			fr = new FileReader("src\\accounts-db.txt");
			br = new BufferedReader(fr);
			while(br.ready() == true) {
				count++;
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
		return count;
	}
	public static void printFile() {
		int length = Database.countLines();
		accounts = new String[length];
		try {
			String line = null;
			fr = new FileReader("src\\accounts-db.txt");
			br = new BufferedReader(fr);
			for (int i = 0; i < length; i++) {
				if (br.ready() == true) {
					line = br.readLine();
					accounts[i] = line;
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
	}
}
