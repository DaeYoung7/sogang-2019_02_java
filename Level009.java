/**
 * CSE3040 HW1
 * Level009.java
 * Purpose: Print 3 students in order of high score
 * 
 * @version 1.0 9/19/2019
 * @author Daeyoung Eo
 */

package cse3040;

import java.util.Scanner;

/**
 * The Student class for memorizing student information.
 */
class Student {
	private int num, score;

	/**
	 * The Student method for the initializing object.
	 * 
	 * @param n-student number, s-student score
	 */
	public Student(int n, int s) {
		this.num = n;
		this.score = s;
	}

	/**
	 * The getNum method for getting student number.
	 */
	public int getNum() {
		return this.num;
	}

	/**
	 * The setNum method for setting student number.
	 * 
	 * @param num-student number
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * The getScore method for getting student score.
	 */
	public int getScore() {
		return this.score;
	}

	/**
	 * The setScore method for setting student score.
	 * 
	 * @param score-student score
	 */
	public void setScore(int score) {
		this.score = score;
	}
}

public class Level009 {

	/**
	 * The inHeap method for inserting Student object in order of score.
	 * 
	 * @param arr-heap array, temp-student object which will be inserted,
	 *                 num-student number, heapSize-number of student object which
	 *                 is inserted in heap array
	 */
	public static void inHeap(Student arr[], Student temp, int num, int heapSize) {
		int i = heapSize + 1;
		while ((i != 1) && (temp.getScore() > arr[i / 2].getScore())) {
			arr[i] = arr[i / 2];
			i /= 2;
		}
		arr[i] = temp;
	}

	/**
	 * The deHeap method for deleting Student object.
	 * 
	 * @param arr-heap array heapSize-number of student object which is inserted in
	 *                 heap array
	 */
	public static Student deHeap(Student arr[], int heapSize) {
		Student item = arr[1];
		Student temp = arr[heapSize];
		int i = heapSize - 1;
		int parent = 1, child = 2;
		while (child <= i) {
			if (child < i && (arr[child].getScore() < arr[child + 1].getScore()))
				child++;
			if (temp.getScore() >= arr[child].getScore())
				break;
			arr[parent] = arr[child];
			parent = child;
			child *= 2;
		}
		arr[parent] = temp;
		return item;
	}

	/**
	 * The main method for the getting student's top 3 score program.
	 * 
	 * @param args Not used
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int i, score, heapSize = 0;

		int studentNumber = 5, getStudentScore = 3;

		Student arr[] = new Student[studentNumber + 1];

		System.out.println("Please enter exam scores of each student");
		for (i = 1; i < (studentNumber + 1); i++) {
			System.out.print("Score of student " + i + ": ");
			score = scan.nextInt();
			Student temp = new Student(i, score);
			inHeap(arr, temp, i, heapSize++);
		}
		for (i = 1; i <= getStudentScore; i++) {
			Student temp = deHeap(arr, heapSize--);
			System.out.printf("The %dst place is student %d with %d points.\n", (i + 1), temp.getNum(),
					temp.getScore());
		}
		scan.close();
	}

}
