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

	/**
	 * Catch an appropriate type of exception
	 */

	public static User checkSignUp(String userName, String password1,
			String password2, Lookup lookup) {
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
				switch (option) {
				case 1:
					
					String userName;
					System.out.println("Enter your UserName: ");
					userName = sc.next();
					String password;
					System.out.println("Enter your Password: ");
					password = sc.next();
					String password2;
					System.out.println("Enter your Password again: ");
					password2 = sc.next();

					sUser = checkSignUp( userName,  password, password2, lookup );
					
					break;
					
				case 2:
					
					login(lookup);
					
					break;
					
				case 3:
					
					return;
					
				default:
					
					throw new InvalidInputException();
				}
			}

			catch (InvalidInputException e) {
				System.err.println("The input is not an integer");
			}
			catch (InputMismatchException e) {
				System.err.println("The input is not an integer");
				sc.nextLine();
			}
		}
		
	}

}
