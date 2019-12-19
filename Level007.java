/**
 * CSE3040 HW1
 * Level007.java
 * Purpose: Find char in text
 * 
 * @version 1.0 9/19/2019
 * @author Daeyoung Eo
 */

package cse3040;

import java.util.Scanner;

public class Level007 {

	/**
	 * The main method for the find char program.
	 * 
	 * @param args Not used
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int cnt = 0;

		System.out.print("Enter a text: ");
		String text = scan.nextLine();

		System.out.print("Enter a letter: ");
		String temp = scan.nextLine();
		char find = temp.charAt(0);

		for (int i = 0; i < text.length(); i++)
			if (find == text.charAt(i))
				cnt++;

		System.out.printf("There are %d %c's in the text.", cnt, find);
		scan.close();
	}

}
