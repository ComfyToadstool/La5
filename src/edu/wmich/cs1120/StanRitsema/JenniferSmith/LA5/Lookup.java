/* Assignment: CS1120 LA5 Flowers Shop
 * Author: Stan Ritsema and Jennifer N. Smith
 * Date: 3/16/18
 * Reference: LA5_Spring2018.docx (LA5 Instructions)
 */

package edu.wmich.cs1120.StanRitsema.JenniferSmith.LA5;

public class Lookup {

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
	 * @throws InvalidInputException
	 *             Exception should be thrown for the following scenarios: 1- if
	 *             username doesn't exist. 2- Password doesn’t exist
	 */
	public User checkLoginAuth(String userName, String password)
			throws InvalidInputException {

		for (int i = 0; i < userList.length; i++) {

			if (userList[i].equals(userName)) {

				if (userList[i].equals(userName, password)) {

					return userList[i];
				}

				else {

					throw new InvalidInputException("Invalid password");

				}
			}
		}

		throw new InvalidInputException("Username does not exist");

	}

	/**
	 * @param userName
	 * @param password1
	 * @param password2
	 * @return
	 * @throws InvalidInputException
	 *             Exception should be thrown for the following scenarios: 1. A
	 *             user is trying to signup using a username that already
	 *             exists. 2. A user tries to login with a username that doesn’t
	 *             exist. 3. A user enters the wrong password. 4. When a user
	 *             enters password a second time, it doesn’t match the first
	 *             password. 5. If password length is less than 6 characters 6.
	 *             If the password is not valid
	 * 
	 */
	public User checkSignUpAuth(String userName, String password1,
			String password2) throws InvalidInputException {

		for (int i = 0; i < userList.length; i++) {

			if (userList[i].equals(userName)) {
				throw new InvalidInputException("Username already exists\n");
			}
		}

		String message = isValidPassword(password1);

		if (message != null) {
			throw new InvalidInputException(message);
		}

		if (!password1.equals(password2)) {
			throw new InvalidInputException("Passwords don't match\n");

		}

		return addUserToTheList(userName, password1);

	}

	/**
	 * The method checks if the password is valid or not: password should
	 * contains: 1- at least one digit one specific characters 2- at least on
	 * lower case letter 3- at least one upper case letter 4- at least one
	 * number
	 * 
	 * @param password
	 * @return: The method returns message error if the password is not valid,
	 *          and returns null if the password is valid
	 */
	public String isValidPassword(String password) {

		String message;

		boolean isValid = true;
		boolean hasDigit = false;
		boolean hasLower = false;
		boolean hasUpper = false;
		boolean hasSpecial = false;

		if (password.length() < 6) {
			return "The password length should be at least 6 characters\n";
		}

		for (int i = 0; i < password.length(); i++) {

			if (Character.isDigit(password.charAt(i))) {
				hasDigit = true;
			}

			else if (Character.isLowerCase(password.charAt(i))) {
				hasLower = true;
			}

			else if (Character.isUpperCase(password.charAt(i))) {
				hasUpper = true;
			}

			else {
				hasSpecial = true;
			}
		}

		if (hasDigit && hasLower && hasUpper && hasSpecial) {
			return null;
		}

		message = "Password should contain:\n";

		if (!hasLower) {
			message += "At least one lower case letter.\n";
		}

		if (!hasUpper) {
			message += "At least one upper case letter.\n";
		}

		if (!hasDigit) {
			message += "At least one number.\n";
		}

		if (!hasSpecial) {
			message += "At least one special characters.\n";
		}

		return message;

	}

	public User[] getUserList() {
		return userList;

	}

	public void setUserList(User[] userList) {
		this.userList = userList;
	}

	/**
	 * 
	 * @param userName
	 * @param password
	 *            This method add new user to the user array
	 * @return user
	 */
	public User addUserToTheList(String userName, String password) {

		User[] listTwo = new User[userList.length + 1];

		for (int i = 0; i < userList.length; i++) {
			listTwo[i] = userList[i];

		}

		listTwo[userList.length] = new User(userList.length + 1, userName,
				password);
		userList = listTwo;

		return listTwo[userList.length - 1];

	}

	/**
	 * This method adds two users to the user list, "You should not change these
	 * users, but you can add new users
	 */

	public User[] createUsers() {
		User[] list = new User[2];

		// Constructor’s arguments: (id, username, password)
		list[0] = new User(1, "sara", "123");
		list[1] = new User(2, "adam", "321");
		return list;
	}

	/**
	 * This method load data to the item list, this list has all the items in
	 * your application "You should not change these data but you can add new
	 * items".
	 * 
	 */
	public Item[] loadItems() {

		Item[] itemList = new Item[10];

		// Constructor’s arguments:(title, quantity, price)
		itemList[0] = new Item(1, "Tulip", 10, 3.00);
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
	 * This method searches for the item by its key and then return the item
	 * object if the item exist else return null
	 */

	public Item getItemById(int key) {

		for (int i = 0; i < storeItemList.length; i++) {
			if (storeItemList[i].getID() == key) {
				return storeItemList[i];
			}
		}

		return null;

	}

	public String toString() {

		String r = "";

		for (int i = 0; i < storeItemList.length; i++) {
				r+= storeItemList[i]+"\n";
		} 
		
		return r;
	}
}
