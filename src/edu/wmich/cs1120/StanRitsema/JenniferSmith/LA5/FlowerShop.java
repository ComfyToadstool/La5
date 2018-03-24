/* Assignment: CS1120 LA5 Flowers Shop
 * Author: Stan Ritsema and Jennifer N. Smith
 * Date: 3/16/18
 * Reference: LA5_Spring2018.docx (LA5 Instructions)
 */

package edu.wmich.cs1120.StanRitsema.JenniferSmith.LA5;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Contains the main. Menu with the user in flower shop.
 * 
 * @author Jennifer Smith
 * @author Stan Ritsema
 *
 */

public class FlowerShop {

	static User sUser;
	static Scanner sc = new Scanner(System.in);

	/**
	 * Use a try-catch block in the main method instead of the default case, you
	 * should have relevant catch clauses: i. Use an appropriate type of
	 * exception if the input is not an integer. ii. You need to use a custom
	 * Exception (InvalidInputException) when the input is not one of the
	 * options on the menu.
	 * 
	 * @param args
	 * @throws IOException 
	 */

	public static void main(String[] args) throws IOException {
		FlowerShop myShop = new FlowerShop();
		Lookup myLookup = new Lookup();
		mainMenu(myLookup);
	}

	/**
	 * Menu to login existing user
	 * 
	 * @param lookup
	 *            instance of lookup for the flower shop
	 * 
	 */
	public static void login(Lookup lookup) {

		try {

			System.out.println("Enter your UserName: ");
			
			String name = sc.nextLine();

			System.out.println("Enter your Password: ");
			
			String pass = sc.nextLine();

			sUser = lookup.checkLoginAuth(name, pass);

		} catch (InvalidInputException e) {

			System.err.println(e.getMessage());
			System.err.flush();

		}

	}
	
	/**
	 * Menu controller for adding flowers to the cart.
	 * Passes true if user bought a flower, false if user
	 * declined.
	 * 
	 * @param lookup
	 * @return
	 */
	public static boolean flowerMenu(Lookup lookup) {
		
		try {
			System.out.println(
					"Do you want to purchase an item(Y,N)?");
			
			String y_n = sc.next().toLowerCase();

			if (y_n.equals("y")) {

				System.out.println("Enter flower id:");
				
				String id_pre = sc.next();
				int id = convert(id_pre);							
				if (lookup.isValidItem(id)) {

					System.out.println("Enter the quantity:");
					
					String quan_pre = sc.next();
					int quantity = convert(quan_pre);

					Item myItem = lookup.getItemById(id);
					sUser.addItemToTheLibrary(myItem, quantity);

				} else {
					throw new InvalidInputException(
							"This flower's id is not existing!");
				}
				return true;

			}else if(y_n.equals("n")){
				return false;
			}else {
				throw new InvalidInputException("Invalid option");
			}

		} catch (InvalidInputException e) {
			System.err.println(e.getMessage());
			System.err.flush();
		}
		
		return true;
		
	}
	
	/**
	 * Menu for flower shop
	 * 
	 * @param lookup
	 *            instance of lookup for the flower shop
	 * 
	 */
	public static void shopMenu(Lookup lookup) throws InvalidInputException, IOException {
		
		int option = -1;
		
		while(option != 4) {
			
			try {
				
				// print menu options
				System.out.println("\n1- Flowers List! \n"
				+ "2- My Cart \n" + "3- Bill \n"
				+ "4- Exit \n" + "Select one of these options: ");
				
				
				String line = sc.next();		
				option = convert(line);
				
				if( (0 >= option) || (5 <= option) ) {
					throw new InvalidInputException("Invalid option");
				}
				
				switch(option) {
				
				case 1:
					System.out.println(lookup);
					
					
					boolean browse = true;

					while (browse) {
						browse = flowerMenu(lookup);
					}
					break;

				case 2:
					String list = sUser.toString();
					if (list == null) {
						System.err.println("Your Shopping Cart is empty.");
						System.err.flush();
					}else {
						System.out.println(sUser);
						System.out.println(
								"Do you want to purchase these items(Y,N)?");
						
						String y_n = sc.next().toLowerCase();
						if (y_n.equals("y")) {
							sUser.writeBill();
							System.err.flush();
						}
					}
					break;

				case 3:
					sUser.readBill();
					System.err.flush();
					break;
				
				}
				
			}catch(InvalidInputException ii) {
				System.err.println(ii.getMessage());
				System.err.flush();
			}
			
		}
		
		System.exit(0);
		
	}

	
	/**
	 * Sign up a new user
	 * @param userName Users username
	 * @param password1 Users first password entry
	 * @param password2 Users second password entry
	 * @param lookup instance of flower shop lookup
	 * @return user
	 */

	public static User checkSignUp(String userName, String password1,
			String password2, Lookup lookup) {

		try {

			return lookup.checkSignUpAuth(userName, password1, password2);

		} catch (InvalidInputException e) {
			System.err.print(e.getMessage());
			System.err.flush();

		}
		return null;
	}

	/**
	 * Use a try-catch block in the main menu method instead of the default
	 * case, you should have relevant catch clauses: i. Use an appropriate type
	 * of exception if the input is not an integer. ii. You need to use a custom
	 * Exception (InvalidInputException) when the input is not one of the
	 * options on the menu.
	 * 
	 * @param args
	 */
	
	/**
	 * Login menu
	 * @param lookup insance of flower shop lookup 
	 * @throws IOException 
	 */
	
	public static void mainMenu(Lookup lookup) throws IOException {
		int option;
		while (true) {

			System.out.println("Welcome to our Flowers Shop!" + "\n1- SignUp \n"
					+ "2- Login \n" + "3- Exit\n"
					+ "Select one of these options:");
			

			try {
				option = sc.nextInt();
				sc.nextLine();
				switch (option) {
				case 1:

					String userName = null;
					sUser = null;

					while (sUser == null) {

						System.out.println("Enter your UserName: ");
						
						userName = sc.nextLine();
						String password;
						System.out.println("Enter your Password: ");
						
						password = sc.nextLine();
						String password2;
						System.out.println("Enter your Password again: ");
						
						password2 = sc.nextLine();

						sUser = checkSignUp(userName, password, password2,
								lookup);

					}

					System.err.println("Login Successfully!");
					System.err.flush();
					shopMenu(lookup);
					break;

				case 2:

					login(lookup);

					if (sUser != null) {
						shopMenu(lookup);
					}

					break;

				case 3:

					System.exit(0);

				default:

					throw new InvalidInputException("Invalid option\n");
				}
			}

			catch (InvalidInputException e) {
//				System.err.flush();
				System.err.print(e.getMessage());
				System.err.flush();

			} catch (InputMismatchException e) {
				System.err.print("The input is not an integer\n");
				System.err.flush();
				sc.nextLine();
			}
		}

	}
	
	public static int convert(String entry) throws InvalidInputException {

		try {
			int x = Integer.parseInt(entry);
			return x;
		}catch(NumberFormatException nf) {
			throw new InvalidInputException("The input is not an integer");
		}
		
	}

}
