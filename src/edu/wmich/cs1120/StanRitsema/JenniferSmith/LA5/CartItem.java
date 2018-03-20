/* Assignment: CS1120 LA5 Flowers Shop
 * Author: Stan Ritsema and Jennifer N. Smith
 * Date: 3/16/18
 * Reference: LA5_Spring2018.docx (LA5 Instructions)
 */

package edu.wmich.cs1120.StanRitsema.JenniferSmith.LA5;

public class CartItem {

	private int id;
	private int quantity;
	private Item item;

	public CartItem(int id, Item item) {
		this.id = id;
		this.quantity = 0;
		this.item = item;
	}

	/**
	 * 
	 * @param quantity
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

	public int getID() {

		return id;
	}

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

	public double getTotal() {
		return quantity * item.getPrice();
	}

	public String toString() {
		String r = item.getTitle();
		r += " (Quantity: " + quantity + "), Price: " + item.getPrice(quantity)
				+ ")";
		return r;

	}
}
