/**
 * CSE3040 HW2
 * Level012.java
 * Purpose: Print binary number of integer
 * 
 * @version 1.0 10/17/2019
 * @author Daeyoung Eo
 */

package cse3040;

import java.util.Scanner;

interface IntSequenceStr {
	boolean hasNext();

	String next();
}

/**
 * This class returns binary of integer which class got before. var bytes is for
 * containing binary value of integer in string type. var flag is for containing
 * information whether next method is executed or not.
 */
class BinarySequenceStr implements IntSequenceStr {
	private String bytes;
	private int flag;

	public BinarySequenceStr(int num) {
		this.bytes = Integer.toBinaryString(num);
		this.flag = 1;
	}

	/**
	 * hasNext method is for checking whether next method is executed or not.
	 * 
	 * @return true if next method is noe executed yet.
	 */
	public boolean hasNext() {
		if (this.flag == 1) {
			this.flag = 0;
			return true;
		} else
			return false;

	}

	/**
	 * next method returns binary of integer in string type.
	 * 
	 * @return binary value of integer in string type.
	 */
	public String next() {
		return bytes;
	}
}

/**
 * The main method for converting integer to binary.
 * 
 * @param args not used.
 */
public class Level012 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		String str = in.nextLine();
		int num = Integer.parseInt(str);
		in.close();
		System.out.println("Integer: " + num);
		IntSequenceStr seq = new BinarySequenceStr(num);
		System.out.print("Binary number: ");
		while (seq.hasNext())
			System.out.print(seq.next());
		System.out.println("");
	}
}
