/**
 * CSE3040 HW2
 * Level016.java
 * Purpose: Count each character's numbers in String.
 * 
 * @version 1.0 10/17/2019
 * @author Daeyoung Eo
 */
package cse3040;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * This class is for separating String into character and counting its number
 */
class Text {
	private String str;
	private int[] arr;
	private char[] tempArr;
	private String[] result;

	/**
	 * constructor
	 */
	public Text() {
		this.arr = new int[128];
		for (int i = 0; i < 128; i++)
			this.arr[i] = 0;
	}

	/**
	 * read file's name and read string in file. separate string into character and
	 * count its number
	 * 
	 * @param fileName
	 */
	public void readTextFromFile(String fileName) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			while (true) {
				str = br.readLine();
				if (str == null)
					break;
				result = str.split("");
				for (int i = 0; i < result.length; i++) {
					tempArr = result[i].toCharArray();
					this.arr[tempArr[0]]++;
				}
			}
		} catch (IOException e) {
			System.out.println("Error: file does not exist.");
		}
	}

	/**
	 * return char c's number
	 * 
	 * @param c
	 * @return arr[c]
	 */
	public String countChar(char c) {
		int temp = c;
		return Integer.toString(this.arr[temp]);
	}
}

public class Level016 {
	public static void main(String args[]) {
		Text t = new Text();
		t.readTextFromFile("input.txt");
		System.out.println("a: " + t.countChar('a'));
		System.out.println("b: " + t.countChar('b'));
		System.out.println("c: " + t.countChar('c'));
	}
}
