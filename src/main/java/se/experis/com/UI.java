package se.experis.com;

import java.util.Scanner;

public class UI {
    private LuhnAlgo luhnAlgo = new LuhnAlgo();

    public static void main(String[] args) {
        UI ui = new UI();
        ui.runMenu();
    }

    public void runMenu() {
        String identificationNumber;
        System.out.println("-----------------------------");
        System.out.println("--  Luhn Checksum Program  --");
        System.out.println("-----------------------------");
        System.out.print("Enter the card number you need to validate: ");
        Scanner scanner = new Scanner(System.in);
        long nr;

        while (scanner.hasNext()) {
            identificationNumber = scanner.next();
            try {
                nr = Long.parseLong(identificationNumber);
                boolean isValid =luhnAlgo.isValidCreditCard(nr);
                if(nr > 0){
                    if(isValid){
                        System.out.println(nr + " is a valid credit card number!");
                    }
                    else {
                        System.out.println(nr + " is not a valid credit card number!");
                    }
                }
                else {
                    System.out.println(nr + " is not positive number. Please enter a positive number!");
                }
            } catch (NumberFormatException e) {
                System.out.println(identificationNumber + " is not a valid number. Please enter a positive number!");
            }
            System.out.print("Enter a new card number you need to validate: ");
        }
        scanner.close();
    }
}
