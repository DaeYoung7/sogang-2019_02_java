/**
 * CSE3040 HW1
 * Level005.java
 * Purpose: Guess a random number
 * 
 * @version 1.0 9/19/2019
 * @author Daeyoung Eo
 */

package cse3040;

import java.util.Scanner;
import java.util.Random;

public class Level005 {

	/**
	 * The main method for the guess number program.
	 * 
	 * @param args Not used
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();

		int num = rand.nextInt(100) + 1;
		int myNum = -1, left = 1, right = 100;
		int cnt = 2;

		System.out.print("[1] Guess a number (1-100): ");
		while (myNum != num) {
			myNum = scan.nextInt();
			if (myNum > num) {
				System.out.println("Too large!");
				right = myNum;
				System.out.printf("[%d] Guess a number (%d-%d): ", cnt++, left, right);
			} else if (myNum < num) {
				System.out.println("Too small!");
				left = myNum;
				System.out.printf("[%d] Guess a number (%d-%d): ", cnt++, left, right);
			}
		}
		System.out.print("Correct!");

		scan.close();
	}
}
