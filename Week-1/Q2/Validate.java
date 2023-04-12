package com.sapient;

import javax.naming.InvalidNameException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Validate {
    static String username = "";
    public static Boolean name(String fullName) {
        try{
            String trim = fullName.replaceAll("\\s", "");
            if(fullName.length() == 0){
                throw new InvalidNameException("Empty name not allowed!!");
            }
            else if(trim.length()<=3){
                throw new InvalidNameException("Name should be minimum of 4 letters");
            }
            else{
                if(!trim.chars().allMatch(Character::isLetter)){
                    throw new InvalidNameException("Name should only contain alphabets");
                }
            }
            username = username+trim.substring(0,4);
        }
        catch (InvalidNameException e){
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public static Boolean dob(String dob) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try{
            LocalDate localDate = LocalDate.parse(dob,dateTimeFormatter);
            LocalDate localDate18 = LocalDate.now().minusYears(18);
            if(localDate.isAfter(localDate18)){
                throw new RuntimeException("Minimum age is 18 to apply!!!");
            }
            username =username + localDate.getDayOfMonth()+localDate.getYear();
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            return false;
        }
        catch (Exception e){
            System.out.println(e.getMessage()+ "Date should be in dd-mm-yyyy format only!!");
            return false;
        }

        return true;
    }

    public static Boolean aadhar(String aadharNumber) {
        try {
            if (aadharNumber.length() != 12) {
                throw new RuntimeException("Error!! Aadhar number should be exactly 12 digits");
            }
            else if(!aadharNumber.matches("[0-9]+")){
                    throw new RuntimeException("Error!! Aaadhar number should only contain numbers");
            }
            username+= aadharNumber.substring(aadharNumber.length()-4);
            return true;
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
