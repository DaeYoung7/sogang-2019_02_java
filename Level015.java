/**
 * CSE3040 HW2
 * Level015.java
 * Purpose: Compare two class instances
 * 
 * @version 1.0 10/17/2019
 * @author Daeyoung Eo
 */
package cse3040;

/**
 * This class contain double array and its length.
 */
class Points {
	private double[] arr;
	private int len = -1;

	/**
	 * constructor
	 * 
	 * @param arr
	 */
	public Points(double[] arr) {
		this.len = arr.length;
		this.arr = new double[len];
		for (int i = 0; i < this.len; i++) {
			this.arr[i] = arr[i];
		}
	}

	/**
	 * This method for printing class object print class object then sum of object's
	 * items will be printed
	 * 
	 * @return String
	 */
	public String toString() {
		if (this.len >= 0) {
			double sum = 0;
			for (int i = 0; i < this.len; i++)
				sum += this.arr[i];
			return "[sum of points: " + Double.toString(sum) + ']';
		} else
			return "null";
	}

	/**
	 * Compare two class objects.
	 * 
	 * return boolean
	 */
	public boolean equals(Object otherObject) {
		if (this == otherObject)
			return true;
		if (otherObject == null)
			return false;
		if (getClass() != otherObject.getClass())
			return false;
		Points other = (Points) otherObject;
		double sum1 = 0.0, sum2 = 0.0;
		for (int i = 0; i < this.len; i++)
			sum1 += this.arr[i];
		for (int i = 0; i < other.getLen(); i++)
			sum2 += other.getNum(i);
		if (sum1 == sum2)
			return true;
		else
			return false;
	}

	/**
	 * get length of array.
	 * 
	 * @return length
	 */
	public int getLen() {
		return this.len;
	}

	/**
	 * get value of array's i-th item
	 * 
	 * @param i
	 * @return arr[i]
	 */
	public double getNum(int i) {
		return this.arr[i];
	}
}

public class Level015 {
	public static void main(String[] args) {
		Points p1 = new Points(new double[] { 1.0, 2.0, 3.0 });
		Points p2 = new Points(new double[] { 4.0, 5.0, 6.0 });
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.equals(p2));
		Points p3 = new Points(new double[] { 1.0, 4.0, 7.0 });
		Points p4 = new Points(new double[] { 3.0, 9.0 });
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(p3.equals(p4));
		Points p5 = new Points(new double[] { 1.0, 2.0 });
		Points p6 = null;
		System.out.println(p5);
		System.out.println(p6);
		System.out.println(p5.equals(p6));
	}
}
