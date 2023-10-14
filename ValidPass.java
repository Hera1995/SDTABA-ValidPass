/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package softdev.validpassapp;

/**
 * ValidPass.java
 * @author Shan Liang
 * 11/05/2023
 */
public class ValidPass {
    //data members - validate alias
    private String alias;
    
    //data members - generate passwords
    private final String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
        "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private int random, numPasswords, remainder;
    private String password, letter;
    private StringBuffer passwordSB = new StringBuffer();
    private int[] numbers = new int[50];
    private String[] passwords = new String[50];
    
    //constructors
    public ValidPass(String alias) {
        this.alias = alias;
    }      

    public ValidPass() {
    }

    public ValidPass(int numPasswords) {
        this.numPasswords = numPasswords;
    }
    
    
    //compute methods
    public boolean validateAlias(){
        //validate the alias length - 24 characters
        if(alias.length() != 24){
            return false;  
        }
        
        //validate the first 3 characters - aib
        if(alias.charAt(0) != 'a'){
            return false;
        }
        if(alias.charAt(1) != 'i'){
            return false;       
        }
        if(alias.charAt(2) != 'b'){
            return false;       
        }         
        
        //validate the rest of characters - digits from 0-9
        for (int i = 3; i < alias.length(); i++) {
            if(alias.charAt(i) != '0' && alias.charAt(i) != '1' && 
                    alias.charAt(i) != '2' && alias.charAt(i) != '3' &&
                    alias.charAt(i) != '4' && alias.charAt(i) != '5' &&
                    alias.charAt(i) != '6' && alias.charAt(i) != '7' &&
                    alias.charAt(i) != '8' && alias.charAt(i) != '9'){
                return false; 
            }
        }
        
        //validate the fixed characters - AIBxx49210955ddddddddcvn
        if(alias.charAt(5) != '4' || alias.charAt(6) != '9' ||
                alias.charAt(7) != '2' || alias.charAt(8) != '1' ||
                alias.charAt(9) != '0' || alias.charAt(10) != '9' ||
                alias.charAt(11) != '5' || alias.charAt(12) != '5'){
            return false;       
        }       
        
        //validate the last 3 digits - in ascending order
        for (int i = 21; i < 23; i++) {
            if((int)alias.charAt(i) >= (int)alias.charAt(i + 1)){
                return false;
            }
        }  
        
        return true;
    }
    
    public String[] generatePasswords(){
        for (int i = 0; i < numPasswords; i++){
            //clear the StringBuffer
            passwordSB.setLength(0);
            
            // Generate 6 random letters
            for (int j = 0; j < 6; j++) {
                //generate a random number between 0-25
                random = (int) (Math.random() * (letters.length - 1));
                //generate a random letter
                letter = letters[random];
                passwordSB.append(letter);
            }
            
            //add an "#" symbol
            passwordSB.append("#");
            
            //calculate the remainder and add it on - 49556891
            remainder = 49556891 % numbers[i];
            passwordSB.append(remainder);
            
            //change the StringBuffer to String and add it to the array
            password = passwordSB.toString();
            passwords[i] = password;
        }
        return passwords;
    }
    
    //setters and getters
    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setNumPasswords(int numPasswords) {
        this.numPasswords = numPasswords;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

}
