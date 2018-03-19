/* Assignment: CS1120 LA5 Flowers Shop
 * Author: Stan Ritsema and Jennifer N. Smith
 * Date: 3/16/18
 * Reference: LA5_Spring2018.docx (LA5 Instructions)
 */

package edu.wmich.cs1120.StanRitsema.JenniferSmith.LA5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FlowerShop {

	static User sUser;
	static Scanner sc = new Scanner(System.in);

	/**
	 * Use a try-catch block in the main method instead of the “default” case,
	 * you should have relevant catch clauses: i. Use an appropriate type of
	 * exception if the input is not an integer. ii. You need to use a custom
	 * Exception (InvalidInputException) when the input is not one of the
	 * options on the menu.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FlowerShop myShop = new FlowerShop();
		Lookup myLookup = new Lookup();
		mainMenu(myLookup);
	}

	/**
	 * Catch an appropriate type of exception
	 */

	public static void login(Lookup lookup) {

	}

	public static void shopMenu(Lookup lookup) {
		while (true) {
			try {
				System.out.println("\n1- Flowers List! \n" + "2- My Cart \n"
						+ "3- Bill \n" + "4- Exit \n"
						+ "Select one of these options:");

				int option = sc.nextInt();
				sc.nextLine();
				
				switch (option) {

				case 1:
					System.out.println(lookup);

					while (true) {
						
						try {
							System.out.println(
									"Do you want to purchase an item(Y,N)?");
							String y_n = sc.nextLine();
							
							if (y_n.equals("y")) {
								System.out.println("Enter flower id:");
								int id = sc.nextInt();
								sc.nextLine();
								System.out.println("Enter the quantity:");
								int quantity = sc.nextInt();
								sc.nextLine();
								Item myItem = lookup.getItemById(id);
								myItem.reduceQuantity(quantity);
								sUser.addItemToTheLibrary(myItem, quantity);
							}

							else {
								break;
							}
							
						} catch (Exception e) {
							System.err.println(e.getMessage());
							System.err.flush();
							sc.nextLine();
						}

					}
					break;

				case 2:
					String list = sUser.toString();
					if (list == null) {
						System.err.println("Your Shopping Cart is empty.");
						System.err.flush();
					}

					else {
						System.out.println(sUser);
					}

					break;

				case 3:
					String bill = sUser.bill();

					if (bill == null) {
						System.err
								.println("You don't have any bill currently.");
						System.err.flush();
					}

					else {
						System.out.println(sUser.bill());

					}

					break;

				case 4:
					return;

				default:

				}

			} catch (Exception e) {
				System.err.println(e.getMessage());
				System.err.flush();

			}
		}
	}

	/**
	 * Catch an appropriate type of exception
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
	 * Use a try-catch block in the main menu method instead of the “default”
	 * case, you should have relevant catch clauses: i. Use an appropriate type
	 * of exception if the input is not an integer. ii. You need to use a custom
	 * Exception (InvalidInputException) when the input is not one of the
	 * options on the menu.
	 * 
	 * @param args
	 */
	public static void mainMenu(Lookup lookup) {
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

					break;

				case 3:

					return;

				default:

					throw new InvalidInputException("Invalid option\n");
				}
			}

			catch (InvalidInputException e) {
				System.err.flush();
				System.err.print(e.getMessage());
				System.err.flush();

			} catch (InputMismatchException e) {
				System.err.print("The input is not an integer\n");
				System.err.flush();
				sc.nextLine();
			}
		}

	}

}
