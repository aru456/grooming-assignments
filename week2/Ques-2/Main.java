package org.example;

import org.example.Model.EmployeType;
import org.example.Model.Employee;
import org.example.Service.EmployeeService;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
             BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\yansaiar\\Downloads\\Week 2\\Week 2\\Question2\\src\\main\\java\\org\\example\\employee.txt"));
             String eachLine;
             while ((eachLine = bufferedReader.readLine()) != null) {
                 String[] entry = eachLine.split(";");
                 Employee employee = new Employee(entry[0],entry[1],LocalDate.parse(entry[2]),EmployeType.valueOf(entry[3]),entry[4],entry[5]);
                 EmployeeService.add(employee);
             }
             bufferedReader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        while(true){
            System.out.print("\n1) Find employee by Employee ID\n2) Display Employees by role\n3) Display employees based on experience\nEnter your option: ");
            Scanner input = new Scanner(System.in);
            int option = Integer.parseInt(input.nextLine());
            if(option == 1){
                System.out.print("Enter employee ID: ");
                String empId = input.nextLine();
                EmployeeService.findById(empId);

            } else if (option == 2) {
                System.out.print("Enter role to find employees: ");
                String role = input.nextLine();
                EmployeeService.findEmployeesByRole(role);
            } else if (option == 3) {
                System.out.print("Enter min experience in years: ");
                int minexp = Integer.parseInt(input.nextLine());
                EmployeeService.findEmployeesByminexp(minexp);

            }else {
                System.out.println("Invalid input");
                break;
            }
        }

    }
}