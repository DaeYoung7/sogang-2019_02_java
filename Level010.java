/**
 * CSE3040 HW1
 * Level010.java
 * Purpose: Multiply two matrices
 * 
 * @version 1.0 9/19/2019
 * @author Daeyoung Eo
 */

package cse3040;

public class Level010 {
	
	/**  
	 * The Print method for printing matrix. 
	 *  
	 * @param a[][] matrix which will be printed 
	 */
	public static void Print(int a[][]) {
		int i, j;
		int aRow = a.length;
		int aCol = a[0].length;
		for (i = 0; i < aRow; i++) {
			for (j = 0; j < aCol; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * The main method for the multiply two matrices program.
	 * 
	 * @param args Not used
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int A[][] = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		final int B[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
		int aRow = A.length, aCol = A[0].length;
		int bCol = B[0].length;
		int C[][] = new int[aRow][bCol];
		int i, j, k, temp;

		for (i = 0; i < aRow; i++) {
			for (j = 0; j < bCol; j++) {
				temp = 0;
				for (k = 0; k < aCol; k++) {
					temp += A[i][k] * B[k][j];
				}
				C[i][j] = temp;
			}
		}

		System.out.println("A");
		Print(A);
		System.out.println("\nB");
		Print(B);
		System.out.println("\nAxB");
		Print(C);
	}

}
