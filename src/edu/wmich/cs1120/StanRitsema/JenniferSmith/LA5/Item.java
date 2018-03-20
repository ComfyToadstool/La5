/* Assignment: CS1120 LA5 Flowers Shop
 * Author: Stan Ritsema and Jennifer N. Smith
 * Date: 3/16/18
 * Reference: LA5_Spring2018.docx (LA5 Instructions)
 */

package edu.wmich.cs1120.StanRitsema.JenniferSmith.LA5;

import java.text.NumberFormat;

/**
 * Describes a store item
 * 
 * @author Jennifer Smith
 *
 */

public class Item {

	private int id;
	private String title;
	private int availableQuantity;
	private double price;

	// formats string to 2 decimal places + $
	public static NumberFormat formatter = NumberFormat.getCurrencyInstance();
	
	/**
	 * Construct a store item
	 * @param id Item
	 * @param title
	 * @param quantity
	 * @param price
	 */
	
	public Item(int id, String title, int quantity, double price) {
		this.id = id;
		this.title = title;
		this.availableQuantity = quantity;
		this.price = price;

	}

	/**
	 * 
	 * @return Available quantity
	 */
	
	public int getAvailableQuantity() {

		return availableQuantity;
	}

	/**
	 * 
	 * @return ID
	 */
	
	public int getID() {

		return id;
	}

	/**
	 * 
	 * @return Title
	 */
	
	public String getTitle() {

		return title;
	}

	/**
	 * 
	 * @return Price
	 */
	
	public double getPrice() {

		return price;
	}

	/**
	 * 
	 * @param quantity
	 * @return
	 */
	
	public String getPrice(int quantity) {

		return formatter.format(quantity * price);
	}
	
	/**
	 * 
	 * @param quantity
	 * @throws InvalidInputException
	 */

	public void reduceQuantity(int quantity) throws InvalidInputException {

		if (availableQuantity >= quantity) {
			availableQuantity -= quantity;
		}

		else {
			throw new InvalidInputException("This quantity is not available.");
		}

	}
	
	/**
	 * 
	 */

	public String toString() {
		return (getID() + " -  " + getTitle() + ",  " + "Price: "
				+ getPrice(1));
	}
}
