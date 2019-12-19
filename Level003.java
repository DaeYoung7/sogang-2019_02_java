package cse3040;

import java.util.Scanner;

public class Level3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner S=new Scanner(System.in);
		
		System.out.print("Enter first number: ");
		//double n1=S.nextDouble();
		String s1=S.nextLine();
		
		System.out.print("Enter second number: ");
		//double n2=S.nextDouble();
		String s2=S.nextLine();
		
		double n1=Double.parseDouble(s1);
		double n2=Double.parseDouble(s2);
		
		System.out.print("The sum of two numbers is: "+(n1+n2));
		
		S.close();
	}

}
