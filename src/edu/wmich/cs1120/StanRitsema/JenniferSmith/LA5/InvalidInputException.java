/* Assignment: CS1120 LA5 Flowers Shop
 * Author: Stan Ritsema and Jennifer N. Smith
 * Date: 3/16/18
 * Reference: LA5_Spring2018.docx (LA5 Instructions)
 */

package edu.wmich.cs1120.StanRitsema.JenniferSmith.LA5;

/**
 * Exception used for invalid user input
 * 
 * @author Jennifer Smith
 * @author Stan Ritsema
 */

public class InvalidInputException extends Exception {

	public static final long serialVersionUID = 1120;

	/**
	 * Construct an InvalidInputException
	 * 
	 * @param message
	 *            description of the error
	 */

	public InvalidInputException(String message) {
		super(message);
	}
}
