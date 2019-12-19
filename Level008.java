/**
 * CSE3040 HW1
 * Level008.java
 * Purpose: Find string in text
 * 
 * @version 1.0 9/19/2019
 * @author Daeyoung Eo
 */

package cse3040;

import java.util.Scanner;

public class Level008 {

	/**
	 * The main method for the find word program.
	 * 
	 * @param args Not used
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int cnt = 0, index;

		System.out.print("Enter a text: ");
		String text = scan.nextLine();

		System.out.print("Enter a string: ");
		String find = scan.nextLine();

		index = text.indexOf(find);
		while (index > -1) {
			cnt++;
			text = text.substring(index + find.length(), text.length());
			index = text.indexOf(find);
		}

		System.out.printf("I have found %d instances of \"%s\".", cnt, find);
		scan.close();
	}

}
