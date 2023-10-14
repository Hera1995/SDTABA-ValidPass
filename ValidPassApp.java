/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package softdev.validpassapp;

/**
 * ValidPassApp.java
 * @author Shan Liang
 * 11/05/2023
 */

import java.util.Scanner;
public class ValidPassApp {

    public static void main(String[] args) {
        //declare variables - validate alias
        String alias;
        int numAliases;
        boolean validAlias;
        
        //declare variables - generate passwords
        int numPasswords;
        int[] numbers = new int[50];
        String[] passwords = new String[50];
        
        //declare and create objects        
        Scanner sc = new Scanner(System.in);
        ValidPass myVP = new ValidPass();
        
        // validate alias
        //input
        System.out.println("How many aliases would you like to validate? ");
        numAliases = sc.nextInt();
        sc.nextLine(); //clear the line break
        
        for (int i = 1; i <= numAliases; i++) {
            System.out.println("Enter alias " + i + ": ");
            alias = sc.nextLine();
            alias = alias.toLowerCase();
            myVP.setAlias(alias);
       
            //compute
            validAlias = myVP.validateAlias();

            //output           
            if(validAlias){
                System.out.println("The alias \"" + alias + "\" is VALID");
            }else{
                System.out.println("The alias \"" + alias + "\" is NOT VALID");
            }
        }
        
        //generate passwords        
        //input - ask for the number of passwords    
        System.out.print("Please enter the number of passwords to generate (minimum 3): ");
        numPasswords = sc.nextInt();

        // input validation
        while (numPasswords < 3) {
            System.out.println("Number of passwords should be minimum 3. Please try again.");
            System.out.println("Please enter the number of passwords to generate (minimum 3): ");
            numPasswords = sc.nextInt();
        }
        
        //send numPasswords to instantiable class
        myVP.setNumPasswords(numPasswords);
        
        //input - ask for the numbers between 11 and 19 (inclusive)
        for (int i = 0; i < numPasswords; i++) {
            System.out.print("Enter a number between 11 and 19 (inclusive) for password " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();

            // Input validation
            while (numbers[i] < 11 || numbers[i] > 19) {
                System.out.println("Number should be between 11 and 19 (inclusive). Please try again.");
                System.out.print("Enter a number between 11 and 19 (inclusive) for password " + (i + 1) + ": ");
                numbers[i] = sc.nextInt();
            }
        }
        
        myVP.setNumbers(numbers);
        
        //generate passwords
        passwords = myVP.generatePasswords();
        
        //output
        System.out.println("Generated passwords:");
        for (int i = 0; i < numPasswords; i++) {
            System.out.println("Password " + (i + 1) + ": " + passwords[i]);
        }
    }
}
