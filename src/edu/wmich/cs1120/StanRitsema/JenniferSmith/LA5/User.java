/* Assignment: CS1120 LA5 Flowers Shop
 * Author: Stan Ritsema and Jennifer N. Smith
 * Date: 3/16/18
 * Reference: LA5_Spring2018.docx (LA5 Instructions)
 */

package edu.wmich.cs1120.StanRitsema.JenniferSmith.LA5;

public class User {

	private int id;
	private String username;
	private String password;
	private CartItem[] cartItems = new CartItem[3];
	private int numItems = 0;

	public User(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;

	}

	public boolean equals(String name) {

		return (username.equals(name));

	}

	public boolean equals(String name, String password) {

		return (username.equals(name) && this.password.equals(password));

	}


	public double getTotal() {
		double total = 0;
		for (int i = 0; i < numItems; i++) {
			total += cartItems[i].getTotal();
		}
		return total;
	}

	public String bill() {
		if(numItems == 0) {
			return null;
		}
		return "Your bill balance is "+ Item.formatter.format(getTotal());
	}

	public boolean isFull() {
		return (numItems == cartItems.length);
	}

	/**
	 * 
	 * @param item
	 * @param quantity
	 * @throws InvalidInputException
	 *             Exception if the user try to add more than three items to the
	 *             cart list, and if there is a thrown exception from
	 *             setQuantity method.
	 */

	public void addItemToTheLibrary(Item item, int quantity)
			throws InvalidInputException {
		
		if (quantity > item.getAvailableQuantity()) {
			throw new InvalidInputException("This quantity is not available.");
		}

		for (int i = 0; i < numItems; i++) {
			if (item.getID() == cartItems[i].getID()) {
				cartItems[i].addQuantity(quantity);
				return;

			}
		}

		if (isFull()) {
			throw new InvalidInputException("Cannot have more than 3 differnt"
					+ " types of the flowers");

		}

		cartItems[numItems] = new CartItem(item.getID(), item);
		cartItems[numItems].setQuantity(quantity);
		++numItems;
	}
	
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
