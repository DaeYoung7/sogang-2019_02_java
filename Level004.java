/**
 * CSE3040 HW1
 * Level004.java
 * Purpose: Print ASCII code of alphabet
 * 
 * @version 1.0 9/19/2019
 * @author Daeyoung Eo
 */

package cse3040;

import java.util.Scanner;

public class Level004 {

	/**
	 * The main method for the ASCII code program.
	 * 
	 * @param args Not used
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanObj = new Scanner(System.in);

		System.out.print("ASCII code teller. Enter a letter: ");
		String input = scanObj.nextLine();
		char need = input.charAt(0);

		System.out.print("The ASCII code of " + need + " is " + (int) need);

		scanObj.close();
	}

}
