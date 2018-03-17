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

	/**
	 * 
	 * @param item
	 * @param quantity
	 * @throws an
	 *             appropriate exception if the user try to add more than three
	 *             items to the cart list, and if there is a thrown exception
	 *             from setQuantity method.
	 */

	public boolean isFull() {
		return numItems == cartItems.length;
	}

	public void addItemToTheLibrary(Item item, int quantity)
			throws InvalidInputException {

		if (quantity > item.getAvailableQuantity()) {
			throw new InvalidInputException();
		}

		for (int i = 0; i < numItems; i++) {
			if (item.getID() == cartItems[i].getID()) {
				cartItems[i].addQuantity(quantity);
				item.reduceQuantity(quantity);
				return;

			}
		}

		if (isFull()) {
			throw new InvalidInputException();
			
		}
		
		cartItems[numItems] = new CartItem(quantity, item);
		item.reduceQuantity(quantity);
		++numItems;
	}
}
