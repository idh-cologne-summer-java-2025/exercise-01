package b;

import java.io.*;

public class ATM {
	int Kontostand = 0;
	/**
	 * Main command loop of the ATM
	 * Asks the user to enter a number, and passes this number to the function cashout(...) 
	 * which actually does the calculation and produces money.
	 * If the user enters anything else than an integer number, the loop breaks 
	 * and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Kontostand = 1500;
		while(true) {
			try {
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				if (Kontostand - amount < 0) {
					System.out.println("Sorry, not enough money in the bank.");
				}
				else cashout(amount);
				System.out.println("dein neuer Kontostand ist: "+Kontostand);
			} catch (Exception e) {
				break;
			}
		}
	}
	
	public void cashout(int amount) {
		Kontostand = Kontostand - amount;	
	};
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};
};