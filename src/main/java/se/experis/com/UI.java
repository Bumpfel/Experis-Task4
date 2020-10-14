package se.experis.com;

import java.util.Scanner;

public class UI {
    private LuhnAlgo luhnAlgo = new LuhnAlgo();
    private Scanner scanner;

    public static void main(String[] args) {
        UI ui = new UI();
        ui.runMenu();
    }

    public void runMenu() {
        String identificationNumber;
        System.out.println("-----------------------------");
        System.out.println("--  Luhn Checksum Program  --");
        System.out.println("-----------------------------");
        final String USAGE = "Usage: <card number minus checksum digit> <checksum digit>";
        System.out.println(USAGE);
        
        scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Input: ");
            identificationNumber = scanner.nextLine();
            try {
                String[] numbers = identificationNumber.split(" ");

                long nr = Long.parseLong(numbers[0]);
                int checkSumDigit = Integer.parseInt(numbers[1]);
                int digits = (nr + "" + checkSumDigit).length();
                System.out.println("Provided: " + checkSumDigit);
                System.out.println("Expected: " + luhnAlgo.calcCheckSum(nr));
                System.out.println();

                boolean isValidCheckSum = luhnAlgo.isValidCheckSum(nr, checkSumDigit);
                System.out.println("Checksum: " + (isValidCheckSum ? " Valid" : "Invalid"));
                boolean isValidCreditCardLength = luhnAlgo.isValidCreditCardLength(nr, checkSumDigit);
                System.out.println("Digits: " + digits + " (" + (isValidCreditCardLength ? "credit card" : "not a credit card") + ")");
            } catch (Exception e) {
                System.out.println(identificationNumber + " is not a valid input. " + USAGE);
            }
            System.out.println();
        }
    }
}
