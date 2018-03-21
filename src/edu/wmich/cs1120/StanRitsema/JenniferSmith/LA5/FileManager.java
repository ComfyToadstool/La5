/* Assignment: CS1120 LA5 Flowers Shop
 * Author: Stan Ritsema and Jennifer N. Smith
 * Date: 3/16/18
 * Reference: LA5_Spring2018.docx (LA5 Instructions)
 */

package edu.wmich.cs1120.StanRitsema.JenniferSmith.LA5;

import java.io.*;

/**
 * Manage system support for bills
 * 
 * @author Jennifer Smith
 *
 */

public class FileManager {

	// File name equals to username
	private String fileName;

	FileWriter output;
	FileReader input;

	/**
	 * Construct an instance fileManager
	 * 
	 * @param fileName
	 *            name of billing file
	 */

	public FileManager(String fileName) {

		this.fileName = fileName + ".txt";

	}

	/**
	 * Create the bill file using the parameter total
	 * 
	 * @param total
	 *            Catch an appropriate type of exception if there is a problem
	 *            while creating or writing on the file.
	 * @throws IOException
	 */
	public void createBillFile(double total) throws IOException {

		try {
			
			File userBill = new File(fileName);

			output = new FileWriter(fileName);

			output.write("Your bill balance is $" + total);

			System.err.println("Your bill is available now!");
			
			output.close();

		} catch (IOException e) {

			System.err.println("Could not create bill!");

		} finally {

			if (output != null) {
				output.close();
			}
		}

	}

	/**
	 * Based on the problem, you need to Catch an appropriate type of exception:
	 * You should handle the exceptions for these cases. 1- if user does not
	 * have a bill yet. 2- if the problem happened while reading the file.
	 * 
	 * @throws IOException
	 */
	
	public void readBill() throws IOException {

		try {

			input = new FileReader(fileName);
			
			BufferedReader bInput = new BufferedReader(input);

			String line;
			
			while( (line = bInput.readLine()) != null) {
				System.err.println(line);
			}
//			int place;
//			while ((place = input.read()) != -1) {
//				System.err.print((char) place);
//			}

			System.out.println();
			
			bInput.close();

		} catch (FileNotFoundException f) {

			System.err.println("You do not have any bill currently.");

		} catch (IOException e) {

			System.err.println("Could not read bill!");

		} finally {

			if (input != null) {
				input.close();
			}

		}

	}

}
