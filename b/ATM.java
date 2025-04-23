package b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATM {
    private double balance = 1000.0;

    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while(true) {
                System.out.print("Enter the amount to withdraw: ");
                String input = br.readLine();
                
                if(input == null || input.equalsIgnoreCase("exit")) {
                    break;
                }

                try {
                    double amount = Double.parseDouble(input);
                    
                    // Check für ganze Zahlen
                    if(amount % 1 != 0) {
                        System.out.println("⚠️ Nur ganze Zahlen erlaubt!");
                        continue;
                    }
                    
                    int intAmount = (int) amount;
                    
                    // Check für positive Zahlen
                    if(intAmount <= 0) {
                        System.out.println("❌ Bitte positive Zahl eingeben");
                        continue;
                    }
                    
                    if(intAmount > balance) {
                        System.out.println("❌ Nicht genug Guthaben!");
                    } else {
                        balance -= intAmount;
                        cashout(intAmount);
                    }
                    
                } catch(NumberFormatException e) {
                    System.out.println("⚠️ Ungültige Eingabe! Bitte Zahl oder 'exit'");
                }
            }
        } catch(IOException e) {
            System.out.println("❌ Kritischer Eingabefehler!");
        }
    }

    private void cashout(int amount) {
        System.out.println("✅ " + amount + "€ ausgezahlt. Neuer Kontostand: " + balance + "€");
    }

    public static void main(String[] args) {
        new ATM().run();
    }
}
