/* Assignment: CS1120 LA5 Flowers Shop
 * Author: Stan Ritsema and Jennifer N. Smith
 * Date: 3/16/18
 * Reference: LA5_Spring2018.docx (LA5 Instructions)
 */

package edu.wmich.cs1120.StanRitsema.JenniferSmith.LA5;


public class Lookup{
	
	public User[] userList;
	public Item[] storeItemList;		

	public Lookup() {		
		userList = createUsers();
		storeItemList = loadItems();
	}

	/**
	 * 
	 * @param userName
	 * @param password
	 * @return Return the user object if it exist
	 * @throws 
	 * An appropriate exception should be thrown for the following scenarios: 
	 * 1- if username doesn't exist.
	 * 2- Password doesn’t exist
	 */	
	public User checkLoginAuth(String userName, String password) {
	}

	/**	 
	 * @param userName
	 * @param password1
	 * @param password2
	 * @return
	 * @throws 
	 *  An appropriate exception should be thrown for the following scenarios:
        * 1.     A user is trying to signup using a username that already exists.
        * 2.     A user tries to login with a username that doesn’t exist.
        * 3.     A user enters the wrong password.
        * 4.     When a user enters password a second time, it doesn’t match the first password.
        * 5.     If password length is less than 6 characters
        * 6.     If the password is not valid
	 * 
	 */
	public User checkSignUpAuth(String userName, String password1, String password2) throws … {	
	}	
	





	/**
	 * The method checks if the password is valid or not:
	 * password should contains:
	 * 1- at least one digit one specific characters
	 * 2- at least on lower case letter
	 * 3- at least one upper case letter
	 * 4- at least one number	
	 * @param password
	 * @return: The method returns message error if the password is not valid,
	 *  and returns null if the password is valid
	 */
	public String isValidPassword(String password){
	}
	public User[] getUserList() {
	}

	public void setUserList(User[] userList) {
	}

	/**
	 * 
	 * @param userName
	 * @param password
	 * This method add new user to the user array
	 * @return user
	 */
	public User addUserToTheList(String userName, String password) {
	}
	
	/**
	 * This method adds two users to the user list,
	 * "You should not change these users, but you
	 * can add new users
	 */
	public User[] createUsers() {
		User[] list = new User[2];
		
		list[0] = new User(1, "sara", "123"); // Constructor’s arguments:  (id, username, password)
		list[1] = new User(2, "adam", "321");
		return list;
	}

	/**
	 * This method load data to the item list, this list has all the
	 * items in your application "You should not change these data
	 * but you can add new items".
	 * 
	 */
	public Item[] loadItems() {
		Item[] itemList = new Item[10];
		itemList[0] = new Item(1, "Tulip", 10, 3.00);// Constructor’s arguments:(title, quantity, price)
		itemList[1] = new Item(2, "Calla", 15, 3.00);
		itemList[2] = new Item(3, "Gerbera", 15, 2.00);
		itemList[3] = new Item(4, "Rose", 30, 2.00);
		itemList[4] = new Item(5, "Purple Mallow", 12, 2.00);
		itemList[5] = new Item(6, "Bergenia", 8, 1.80);
		itemList[6] = new Item(7, "Baneberry", 20, 1.95);
		itemList[7] = new Item(8, "Aster", 25, 1.50);
		itemList[8] = new Item(9, "Sunflower", 8, 1.00);
		itemList[9] = new Item(10, "Gladiolus", 10, 0.75);
		
		return itemList;	
      }
	/**
	 * This method searches for the item by its key
	 * and then return the item object if the item exist
	 * else return null 
	 */
	public Item getItemById(int key) {
		
	}
}

