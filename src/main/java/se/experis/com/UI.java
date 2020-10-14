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
        String identificationnumber;
        System.out.println("Enter the number you need to validate!");
        Scanner scanner = new Scanner(System.in);
        long nr;

        while (scanner.hasNext()) {
            identificationnumber = scanner.next();
            try {
                nr = Long.parseLong(identificationnumber);
                if(nr>0){
                    System.out.println(identificationnumber + " is a valid number!");
                    luhnAlgo.isValidCreditCard(nr);
                    scanner.close();
                    break;
                }
                else {
                    System.out.println("Please enter a positive number!");
                }
            } catch (NumberFormatException e) {
                System.out.println(identificationnumber + " is not a valid number!");
            }
        }
    }
}
