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
	 *             Exception if user send quantity more than the available quantity in the
	 *             store
	 */

	public void setQuantity(int quantity) throws InvalidInputException {
		this.quantity = quantity;
	}

	public int getID() {

		return id;
	}

	public void addQuantity(int quantity) {

		this.quantity += quantity;
	}
	
	public double getTotal() {
		return quantity*item.getPrice();
	}
	
	public String toString() {
		String r = item.getTitle();
		r += " (Quantity: "+ quantity +"), Price: $"+item.getPrice(quantity)+")";
		return r;

	}
}
