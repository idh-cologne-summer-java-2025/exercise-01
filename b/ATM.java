package b;

import java.io.*;

public class ATM {
	
	int mOA1 = 500; //amount of money on account 1
	
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
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				System.out.println("SHUTTING DOWN..., have a nice day");
				System.exit(0);
			}
		}
	}
	
	public void cashout(int amount) {
		if(amount<=mOA1&&amount>0){
			mOA1 = mOA1 - amount;
			System.out.println("Here, please take your money. \n"
			+ "You got "+mOA1+"€ left on your account.");
		}
		else if(amount==0){
			System.out.println("Money isn't everything, is it?");
		}
		else if(amount<0) { 
			System.out.println("The function to pay in money has "
			+ "yet to be programmed. \nPlease come by again in in about two years.");
		}
		else {
			System.out.println("Sorry, you don't have enough money on your account!");
		}
	};
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	}
}