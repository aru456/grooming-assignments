package com.sapient;

import java.util.Scanner;

public class AppMain {
    enum Increment {
        ASSOCIATE(20),
        SRASSOCIATE(30),
        MANAGER(45);
        private int val;
        Increment(int val) {
            this.val = val;
        }

    }
    public static void printme(Increment inc, int salary){
        double mul = 1 + (double) inc.val/100;
        double sal = salary*mul;
        System.out.println("Found a role for you **** "+inc+" **** and expected salary is " + sal + " INR");
    }
    public static void main (String[] args){
        System.out.println("What is your tech stack? 1)JAVA 2)SAP 3)QA 4)OTHERS");
        Scanner input = new Scanner(System.in);
        String techStack = input.nextLine();
        System.out.println("Years of experience in the field: ");
        int exp = input.nextInt();
        System.out.println("What is your current salary");
        int salary = input.nextInt();
        Increment inc = null;
        if(techStack.equalsIgnoreCase("JAVA") && exp >= 8){
            inc = Increment.MANAGER;
            printme(inc,salary);

        }
        else if(techStack.equalsIgnoreCase("SAP") && exp >= 4){
            inc = Increment.SRASSOCIATE;
            printme(inc,salary);
        }
        else if(techStack.equalsIgnoreCase("QA") && exp >= 3){
            inc = Increment.ASSOCIATE;
            printme(inc,salary);
        }
        else {
            throw new IllegalArgumentException("No open roles for your profile!!");
        }




    }
}
