package com.sapient;

import java.util.Scanner;

public class AppMain {

    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        boolean flag = false;
        String fullName = null;
        String dob =null,aadharNumber = null;
        while(Boolean.FALSE.equals(flag)){
            System.out.print("Enter your firsname middlename lastname: ");
             fullName = input.nextLine();
            flag = Validate.name(fullName);
        }
        flag =false;
        while(Boolean.FALSE.equals(flag)) {
            System.out.print("Enter your Date of Birt in dd-mm-yyyy format: ");
             dob = input.nextLine();
            flag = Validate.dob(dob);
        }
        flag = false;
        while(Boolean.FALSE.equals(flag)) {
            System.out.println("Enter your 12 digit Aadhar number: ");
            aadharNumber = input.nextLine();
            flag = Validate.aadhar(aadharNumber);
        }
        System.out.println("Your username is: "+ Validate.username);
    }
}
