package b;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ATM {
		
	// Verwenden einer Map, um Kontonummern (Integer) und Kontostände (Integer) zu speichern.
    private Map<Integer, Integer> accounts;
    // Variable zur Speicherung des aktuellen Bargeldbestands im Geldautomaten.
    private int atmCashBalance;

    /**
     * Konstruktor für die ATM-Klasse.
     * Initialisiert die Beispielkonten und den a
}
	
	/**
	 * Main command loop of the ATM
	 * Asks the user to enter a number, and passes this number to the function cashout(...) 
	 * which actually does the calculation and produces money.
	 * If the user enters anything else than an integer number, the loop breaks 
	 * and the program exists
	 */
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to the ATM!");

        while (true) {
            try {
                // Schritt 1: Kontonummer abfragen
                System.out.print("Enter your account number (or type 'exit' to quit): ");
                String accountNumStr = br.readLine();

                // Prüfen, ob der Benutzer das Programm beenden möchte
                if (accountNumStr == null || accountNumStr.trim().equalsIgnoreCase("exit")) {
                    break;
                }

                int accountNumber = Integer.parseInt(accountNumStr.trim());

                // Schritt 2: Abhebungsbetrag abfragen
                System.out.print("Enter the amount to withdraw: ");
                String amountStr = br.readLine();

                 // Prüfen auf leere Eingabe für Betrag
                if (amountStr == null || amountStr.trim().isEmpty()) {
                     System.out.println("Invalid amount entered. Please try again.");
                     continue; // Nächste Iteration der Schleife
                }

                int amount = Integer.parseInt(amountStr.trim());

                // Schritt 3: Auszahlungsprozess aufrufen
                processWithdrawal(accountNumber, amount);
             
                System.out.println("------------------------------------"); // Trennlinie für bessere Lesbarkeit

                
                
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid input. Please enter numbers only for account and amount.");
                // Die Schleife wird fortgesetzt, um eine neue Eingabe zu ermöglichen
            } catch (Exception e) {
                System.err.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace(); // Gibt detaillierte Fehlermeldung aus (für Debugging)
                break; // Beendet die Schleife bei unerwarteten Fehlern
            }
        }
        System.out.println("Thank you for using the ATM. Goodbye!");
    }

	
	public ATM() {
        accounts = new HashMap<>();
        // Fügen Sie hier Beispielkonten mit ihren Anfangssalden hinzu.
        // Format: accounts.put(Kontonummer, Kontostand);
        accounts.put(456, 1500); // Konto 456 hat 1500 Währungseinheiten

        // Legen Sie den anfänglichen Bargeldbestand des Geldautomaten fest.
       
    }
	
	public void processWithdrawal(int accountNumber, int amount) {
        // Validierung: Betrag muss positiv sein
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be a positive number.");
            return; // Beendet die Methode hier
        }

        // 1. Prüfen, ob das Konto existiert
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Sorry, account number " + accountNumber + " was not found.");
            return; // Beendet die Methode hier
        }

        // Hole den aktuellen Kontostand
        int currentAccountBalance = accounts.get(accountNumber);

        
        // 3. Prüfen, ob das *Konto* genug Guthaben hat
        if (amount > currentAccountBalance) {
            System.out.println("Sorry, you don't have enough money in the bank.");
            return; // Beendet die Methode hier
        }

        // 4. Wenn alle Prüfungen erfolgreich sind: Auszahlung durchführen
        // Aktualisiere den Kontostand
        accounts.put(accountNumber, currentAccountBalance - amount);
        // Aktualisiere den Bargeldbestand des Automaten
        this.atmCashBalance -= amount; // Kurzform für: this.atmCashBalance = this.atmCashBalance - amount;

        System.out.println("Ok, here you go!");
        // Optional: Zeige dem Benutzer den neuen Kontostand an
        System.out.println("Your new account balance is: " + accounts.get(accountNumber)); }
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};
};