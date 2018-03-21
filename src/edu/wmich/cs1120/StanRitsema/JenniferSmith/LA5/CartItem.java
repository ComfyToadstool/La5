/* Assignment: CS1120 LA5 Flowers Shop
 * Author: Stan Ritsema and Jennifer N. Smith
 * Date: 3/16/18
 * Reference: LA5_Spring2018.docx (LA5 Instructions)
 */

package edu.wmich.cs1120.StanRitsema.JenniferSmith.LA5;

/**
 * Describes an item in the user shopping cart
 * 
 * @author Jennifer Smith
 *
 */

public class CartItem {

	private int id;
	private int quantity;
	private Item item;

	/**
	 * Construct a cart item
	 * 
	 * @param id
	 *            Item id
	 * @param item
	 *            The item
	 */

	public CartItem(int id, Item item) {
		this.id = id;
		this.quantity = 0;
		this.item = item;
	}

	/**
	 * Set the quantity
	 * 
	 * @param quantity
	 *            number of this item in the cart
	 * @throws InvalidInputException
	 *             Exception if user send quantity more than the available
	 *             quantity in the store
	 */

	public void setQuantity(int quantity) throws InvalidInputException {

		try {
			item.reduceQuantity(quantity);
			this.quantity = quantity;
		} catch (InvalidInputException e) {
			System.err.flush();
			System.err.println(e.getMessage());
			System.err.flush();
			System.err.println("The available quantity in the store is "
					+ item.getAvailableQuantity()
					+ " flowers, and your ordered quantity is " + quantity
					+ " flowers.");
			System.err.flush();

		}
	}

	/**
	 * 
	 * @return item id
	 */

	public int getID() {

		return id;
	}

	/**
	 * Increment the quantity
	 * 
	 * @param quantity
	 *            number to increment the quantity
	 */

	public void addQuantity(int quantity) {

		try {
			item.reduceQuantity(quantity);
			this.quantity += quantity;
		} catch (InvalidInputException e) {
			System.err.flush();
			System.err.println(e.getMessage());
			System.err.flush();
			System.err.println("The available quantity in the store is "
					+ item.getAvailableQuantity()
					+ " flowers, and your ordered quantity is " + quantity
					+ " flowers.");
			System.err.flush();
		}
	}

	/**
	 * Return the total of this items in the shopping cart
	 * 
	 * @return the total of this items in the shopping cart
	 */

	public double getTotal() {
		return quantity * item.getPrice();
	}

	/**
	 * return a string representation of this item
	 */

	public String toString() {
		String r = item.getTitle();
		r += " (Quantity: " + quantity + "), Price: " + item.getPrice(quantity)
				+ ")";
		return r;

	}
}
