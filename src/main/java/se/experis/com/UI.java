package se.experis.com;

import java.util.Scanner;

public class UI {
    LuhnAlgo luhnAlgo = new LuhnAlgo();
    static boolean exit;

    public static void main(String[] args) {
        UI ui= new UI();
        ui.runMenu();

    }

    public void runMenu() {
        while (!exit) {
            int cardNumber = getMenuChoice();
            luhnAlgo.isValidCreditCard(cardNumber);
            System.out.println("Nu har användaren matat in rätt siffra. Vi kommer att låta användaren komma ur denna loop när vi joina våra lösningar!");
        }
    }

    public int getMenuChoice() {
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.print("Please enter the number you need to validate: ");
            try {
                choice = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Enter positive numbers please!");
            }

        } while (choice < 0);
        return choice;
    }
}
