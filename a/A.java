package a;

import java.util.Random;

// Comments explain the wrong code

public class A {
	public static void main(String[] args) { // wrong Syntax main-Methode 
		String s = "Hello World!"; // wrong variable: String
		char c = 'X'; // char unused ¯\_(ツ)_/¯
		int[] numberList = new int[15]; // create 'new' list
		Random random = new Random(); // create new Object
		
		
		for (int i = 0; i < numberList.length; i++) { // interval wrongly defined
			numberList[i] = random.nextInt(100);
		}
		
		int sum = 0; // missing variable
		for (int i = 0; i < numberList.length; i++) { // interval wrongly defined
			sum += numberList[i];
		}
		if (sum > 750) { //wrong Syntax: missing brackets
			System.out.println(s); // wrong print method
		}
	}
}