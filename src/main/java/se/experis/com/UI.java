package se.experis.com;

import java.util.Scanner;

public class UI {
    private LuhnAlgo luhnAlgo = new LuhnAlgo();

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
                boolean isValid =luhnAlgo.isValidCreditCard(nr);
                if(nr>0){

                    if(isValid){
                        System.out.println(nr + " is a valid credit card number!");
                        scanner.close();
                        break;
                    }
                    else {
                        System.out.println(nr + " is not a valid credit card number!");
                        System.out.println("Enter a new number you need to validate!");
                    }
                }
                else {
                    System.out.println(nr + " is not positive number. Please enter a positive numbers!");
                }
            } catch (NumberFormatException e) {
                System.out.println(identificationnumber + " is not a valid number, Please enter positve numbers!");
            }
        }
    }
}
