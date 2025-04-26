package a;

import java.util.Random;

public class A {
	public static void main (String [] args) {
		String s = "Hello World!";
		char c = 'X';
		int[] numberList = new int[15];
		Random random = new Random();
		for (int i = 0; i < numberList.length; i++) {
			numberList[i] = random.nextInt(100);
		}
		
		int sum = 0;
		for (int i = 0; i < numberList.length; i++) {
			sum += numberList[i];
		}
		if (sum > 750) {
			System.out.println(s);
		}
	}
}