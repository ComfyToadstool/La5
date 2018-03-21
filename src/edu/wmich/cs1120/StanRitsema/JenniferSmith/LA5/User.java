/* Assignment: CS1120 LA5 Flowers Shop
 * Author: Stan Ritsema and Jennifer N. Smith
 * Date: 3/16/18
 * Reference: LA5_Spring2018.docx (LA5 Instructions)
 */

package edu.wmich.cs1120.StanRitsema.JenniferSmith.LA5;

import java.io.IOException;

/**
 * Flower shop customer manages username, password, and shopping cart
 * 
 * @author Jennifer Smith
 *
 */

public class User {

	private int id;
	private String username;
	private String password;
	private CartItem[] cartItems = new CartItem[3];
	private int numItems = 0;
	private FileManager fileManager;

	/**
	 * Construct a user
	 * 
	 * @param id
	 *            Unique user id
	 * @param username
	 *            Users username
	 * @param password
	 *            Users password
	 */

	public User(int id, String username, String password) {

		this.id = id;
		this.username = username;
		this.password = password;

		fileManager = new FileManager(username);
	}

	/**
	 * Returns true if the parameter matches the username
	 * 
	 * @param name
	 *            Username
	 * @return true if the parameter matches the username
	 */

	public boolean equals(String name) {

		return (username.equals(name));

	}

	/**
	 * Returns true if both the username and password match
	 * 
	 * @param name
	 *            Username
	 * @param password
	 *            User password
	 * @return true if both the username and password match
	 */

	public boolean equals(String name, String password) {

		return (username.equals(name) && this.password.equals(password));

	}

	/**
	 * 
	 * @return The total of all items in the cart
	 */

	public double getTotal() {
		double total = 0;
		for (int i = 0; i < numItems; i++) {
			total += cartItems[i].getTotal();
		}
		return total;
	}

	/**
	 * 
	 * @return bill summary
	 */

	public String bill() {
		if (numItems == 0) {
			return null;
		}
		return "Your bill balance is " + Item.formatter.format(getTotal());
	}
	
	/**
	 * Read the current bill.  Execeptions handled in FileManager class.
	 * 
	 * @throws IOException
	 */
	public void readBill() throws IOException {
		fileManager.readBill();
	}

	/**
	 * Write the bill to the file
	 * 
	 * @throws IOException
	 */

	public void writeBill() throws IOException {
		fileManager.createBillFile(getTotal());
	}

	/**
	 * 
	 * @return true if the shopping cart is full
	 */

	public boolean isFull() {
		return (numItems == cartItems.length);
	}

	/**
	 * Add the parameter item to the shopping cart.
	 * 
	 * @param item
	 *            Shopping item
	 * @param quantity
	 *            Number of items
	 * @throws InvalidInputException
	 *             Exception if the user try to add more than three items to the
	 *             cart list, and if there is a thrown exception from
	 *             setQuantity method.
	 */

	public void addItemToTheLibrary(Item item, int quantity)
			throws InvalidInputException {

		if (quantity > item.getAvailableQuantity()) {
			throw new InvalidInputException("This quantity is not available."
					+ "\nThe available quantity in the store is "
					+ item.getAvailableQuantity()
					+ " flowers, and your ordered quantity is " + quantity
					+ " flowers.\n");
		}

		for (int i = 0; i < numItems; i++) {
			if (item.getID() == cartItems[i].getID()) {
				cartItems[i].addQuantity(quantity);
				return;

			}
		}

		if (isFull()) {
			throw new InvalidInputException(
					"You cannot have more than 3 differnt"
							+ " types of the flowers");

		}

		cartItems[numItems] = new CartItem(item.getID(), item);
		cartItems[numItems].setQuantity(quantity);
		++numItems;
	}

	/**
	 * Return a string that itemizes the shopping cart
	 */
	
	public String toString() {

		String r = "";
		if (numItems == 0) {
			return null;
		}

		int total = 0;

		for (int i = 0; i < numItems; i++) {
			r += cartItems[i] + "\n";
			total += cartItems[i].getTotal();
		}

		r += "Total Price: " + Item.formatter.format(total);

		return r;
	}

}
