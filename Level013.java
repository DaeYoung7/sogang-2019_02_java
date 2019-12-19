/**
 * CSE3040 HW2
 * Level013.java
 * Purpose: Calculate and sum area of multiple shapes.
 * 
 * @version 1.0 10/17/2019
 * @author Daeyoung Eo
 */

package cse3040;

/**
 * This class is abstract class and will be used to calculate area
 */
abstract class Shape {

	/**
	 * calculate area method
	 */
	abstract public double calArea();
}

/**
 * calculate Circle area
 */
class Circle extends Shape {
	private double r;

	/**
	 * constructor
	 * 
	 * @param r
	 */
	public Circle(double r) {
		this.r = r;
	}

	/**
	 * calculate Circle area which has r for radius
	 * 
	 * @return area of Circle
	 */
	@Override
	public double calArea() {
		return this.r * this.r * Math.PI;
	}
}

/**
 * calculate Square area
 */
class Square extends Shape {
	private double n;

	/**
	 * constructor
	 * 
	 * @param n
	 */
	public Square(double n) {
		this.n = n;
	}

	/**
	 * calculate Square area which has n on its side.
	 * 
	 * @return area of Square
	 */
	@Override
	public double calArea() {
		return this.n * this.n;
	}
}

/**
 * calculate Rectangle area
 */
class Rectangle extends Shape {
	private double n, m;

	/**
	 * constructor
	 * 
	 * @param n,m
	 */
	public Rectangle(double n, double m) {
		this.n = n;
		this.m = m;
	}

	/**
	 * calculate Rectangle area which has n,m on its sides.
	 * 
	 * @return area of Rectangle
	 */
	@Override
	public double calArea() {
		return this.n * this.m;
	}
}

public class Level013 {
	/**
	 * This main method for calculate area of multiple shapes
	 * 
	 * @param args not used
	 */
	public static void main(String args[]) {
		Shape[] arr = { new Circle(5.0), new Square(4.0), new Rectangle(3.0, 4.0), new Square(5.0) };
		System.out.println("Total area of the shapes is: " + sumArea(arr));
	}

	/**
	 * This method returns sum of Shape object.calArea
	 * 
	 * @param area
	 * @return sum
	 */
	static double sumArea(Shape[] area) {
		double sum = 0;
		for (int i = 0; i < area.length; i++) {
			sum += area[i].calArea();
		}
		return sum;
	}
}
