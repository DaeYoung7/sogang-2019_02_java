/**
 * CSE3040 HW2
 * Level014.java
 * Purpose: Calculate distance(Euclidean, Manhattan)
 * 
 * @version 1.0 10/17/2019
 * @author Daeyoung Eo
 */
package cse3040;

/**
 * This class makes double array which contains point values.
 */
class Point {
	private double[] arr;
	private int len;

	/**
	 * constructor get double array and copy its value to class double array.
	 * 
	 * @param arr
	 */
	public Point(double[] arr) {
		this.len = arr.length;
		this.arr = new double[len];
		for (int i = 0; i < len; i++)
			this.arr[i] = arr[i];
	}

	/**
	 * This method is for getting length of array.
	 * 
	 * @return this.len
	 */
	public int getLen() {
		return this.len;
	}

	/**
	 * This method is for getting value of array's i-th item.
	 * 
	 * @param i
	 * @return this.arr[i]
	 */
	public double getNum(int i) {
		return this.arr[i];
	}
}

/**
 * This class calculates Euclidean distance
 */
class EuclideanDistance {

	/**
	 * This method calculates Euclidean distance if p1's dimension is different with
	 * p2's dimension, method returns -1.0
	 * 
	 * @param p1
	 * @param p2
	 * @return Euclidean distance of p1,p2
	 */
	static double getDist(Point p1, Point p2) {
		double sum = 0.0;
		if (p1.getLen() != p2.getLen())
			return -1.0;
		else {
			for (int i = 0; i < p1.getLen(); i++)
				sum = (p1.getNum(i) - p2.getNum(i)) * (p1.getNum(i) - p2.getNum(i)) + sum;
			sum = Math.sqrt(sum);
			return sum;
		}
	}
}

/**
 * This class calculates Manhattan distance
 */
class ManhattanDistance {
	/**
	 * This method calculates Manhattan distance if p1's dimension is different with
	 * p2's dimension, method returns -1.0
	 * 
	 * @param p1
	 * @param p2
	 * @return Manhattan distance of p1,p2
	 */
	static double getDist(Point p1, Point p2) {
		double sum = 0.0;
		if (p1.getLen() != p2.getLen())
			return -1.0;
		else {
			for (int i = 0; i < p1.getLen(); i++)
				sum = Math.abs(p1.getNum(i) - p2.getNum(i)) + sum;
			return sum;
		}
	}
}

public class Level014 {
	public static void main(String[] args) {
		Point p1 = new Point(new double[] { 1.0, 2.0, 3.0 });
		Point p2 = new Point(new double[] { 4.0, 5.0, 6.0 });
		System.out.println("Euclidean Distance: " + EuclideanDistance.getDist(p1, p2));
		System.out.println("Manhattan Distance: " + ManhattanDistance.getDist(p1, p2));
		Point p3 = new Point(new double[] { 1.0, 2.0, 3.0 });
		Point p4 = new Point(new double[] { 4.0, 5.0 });
		System.out.println("Euclidean Distance: " + EuclideanDistance.getDist(p3, p4));
		System.out.println("Manhattan Distance: " + ManhattanDistance.getDist(p3, p4));
	}
}