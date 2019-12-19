/**
 * CSE3040 HW1
 * Level006.java
 * Purpose: Lotto game
 * 
 * @version 1.0 9/19/2019
 * @author Daeyoung Eo
 */

package cse3040;

import java.util.Scanner;
import java.util.Random;

public class Level006 {

	/**
	 * The main method for the lotto game program.
	 * 
	 * @param args Not used
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();

		int lottoNum[] = new int[6];
		int myNum[] = new int[6];
		int i, j = 1, cnt = 0, min, temp = 0;

		for (i = 0; i < 6; i++) {
			lottoNum[i] = rand.nextInt(45) + 1;
			for (j = 0; j < i; j++) {
				if (lottoNum[i] == lottoNum[j]) {
					i--;
					break;
				}
			}
		}

		for (i = 0; i < 6; i++) {
			System.out.print("[Lotto] Enter number #" + (i + 1) + " (1-45): ");
			myNum[i] = scan.nextInt();
			for (j = 0; j < 6; j++) {
				if (myNum[i] == lottoNum[j])
					cnt++;
			}
		}
		System.out.print("This week's lotto numbers:");
		for (i = 0; i < 6; i++) {
			min = 50;
			for (j = 0; j < 6; j++) {
				if (lottoNum[j] < min) {
					min = lottoNum[j];
					temp = j;
				}
			}
			System.out.print(" " + min);
			lottoNum[temp] = 100;
		}
		System.out.println("\nYou matched " + cnt + " numbers.");

		scan.close();
	}

}
