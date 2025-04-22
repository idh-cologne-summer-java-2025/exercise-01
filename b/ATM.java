package b;

import java.io.*;

public class ATM {

    private int balance = 100; 

    /**
     * Main command loop of the ATM
     */
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Enter the amount to withdraw: ");
                String input = br.readLine();

                // 👋 Programm beenden, wenn "exit" eingegeben wird
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Goodbye!");
                    break;
                }

                int amount = Integer.parseInt(input); // versuche, Zahl zu lesen

                if (amount <= 0) {
                    System.out.println("Please enter a positive amount.");
                } else if (amount > balance) {
                    System.out.println("Sorry, not enough money in the bank.");
                } else {
                    balance -= amount;
                    System.out.println("Ok, here is your money, enjoy!");
                }

            } catch (NumberFormatException e) {
                // Wenn keine ganze Zahl eingegeben wurde
                System.out.println("Invalid input. Please enter a whole number or 'exit'.");
            } catch (IOException e) {
                System.out.println("Input error. Exiting...");
                break;
            }
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}
