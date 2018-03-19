/* Assignment: CS1120 LA5 Flowers Shop
 * Author: Stan Ritsema and Jennifer N. Smith
 * Date: 3/16/18
 * Reference: LA5_Spring2018.docx (LA5 Instructions)
 */

package edu.wmich.cs1120.StanRitsema.JenniferSmith.LA5;

public class Item {
	
	private int id;
	private String title;
	private int availableQuantity;
	private double price;

	public Item(int id, String title, int quantity, double price) {
		
		this.id = id;
		this.title = title;
		this.availableQuantity = quantity;
		this.price = price;

	}

	public int getAvailableQuantity() {

		return availableQuantity;
	}

	public String toString() {
		return (getID() + " -  " + getTitle() + ",  " + "Price: $" + getPrice());
	}

	public int getID() {

		return id;
	}
	
	public String getTitle() {
		
		return title;
	}
	
	public double getPrice() {
		
		return price;
	}

	public void reduceQuantity(int quantity) {
		availableQuantity -= quantity;
		
	}

}
