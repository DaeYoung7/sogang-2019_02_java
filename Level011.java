/**
 * CSE3040 HW2
 * Level011.java
 * Purpose: Calculate fibonacci Sequence
 * 
 * @version 1.0 10/17/2019
 * @author Daeyoung Eo
 */

package cse3040;

interface IntSequence {
	boolean hasNext();

	int next();
}

/**
 * This class calculate fibonacci sequence hasNext method always return true
 * next method returns temp1+temp2 temp1 stores number that this method returned
 * two loops before temp2 stores number that this method returned two loops
 * before temp is for temporary storing a number
 */
class FibonacciSequence implements IntSequence {
	int temp = 0;
	int temp1 = 0;
	int temp2 = 1;
	int num = 0;

	public boolean hasNext() {
		this.num++;
		return true;
	}

	public int next() {
		if (this.num == 1)
			return temp1;
		else if (this.num == 2)
			return temp2;
		else {
			temp = temp1 + temp2;
			temp1 = temp2;
			temp2 = temp;
			return temp2;
		}
	}
}

/**
 * The main method for the fibonacci Sequence program
 * 
 * @param args not used
 */
public class Level011 {
	public static void main(String[] args) {
		IntSequence seq = new FibonacciSequence();
		for (int i = 0; i < 20; i++) {
			if (seq.hasNext() == false)
				break;
			System.out.print(seq.next() + " ");
		}
		System.out.println(" ");
	}
}
