package b;

import java.io.*;

public class ATM {
	
	private float availableMoney = 100000.0f;

	/**
	 * Main command loop of the ATM
	 * Asks the user to enter a number, and passes this number to the function cashout(...) 
	 * which actually does the calculation and produces money.
	 * If the user enters anything else than an integer number, the loop breaks 
	 * and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.print("Enter the amount to withdraw: ");
				float amount = Float.parseFloat(br.readLine());
				if(amount < 0) {
					System.out.println("Negative amount not allowed.");
					continue;
				} else if(amount > availableMoney) {
					System.out.println("Amount exceeds available Money.");
					continue;
				}
				cashout(amount);

			} catch (Exception e) {
				break;
			}
		}
	}
	
	public void cashout(float amount) {
				availableMoney -= amount;
				System.out.println("You have withdrawn: " + amount + " euros.");
				System.out.println("Available money: " + availableMoney + " euros.");
	};
	

	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};
};