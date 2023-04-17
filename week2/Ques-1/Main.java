package org.example;

import org.example.model.Employee;
import org.example.model.EmployeeStatus;
import org.example.model.EmploymentType;
import org.example.service.EmployeeService;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.print(" a) Add New employee \n b) Delete Employee \n c) Update Emp Type \n d) Update Role of an emp \n e) Find Senior most employees \n f) List employees by status \n\n Choose option:");
            String option = in.nextLine();
            if (Objects.equals(option, "a")) {
                Employee employee = new Employee("1", "Srinu", LocalDate.now().minusYears(1), "SDE", EmployeeStatus.ACTIVE, EmploymentType.CONTRACT);
                Employee employee1 = new Employee("2", "Niranjan", LocalDate.now().minusYears(10), "CEO", EmployeeStatus.ACTIVE, EmploymentType.FULLTIME);
                Employee employee2 = new Employee("3", "Renuka", LocalDate.now().minusYears(5), "Manager", EmployeeStatus.SERVINGNOTICE, EmploymentType.FULLTIME);
                Employee employee3 = new Employee("4", "Madavi", LocalDate.now().minusYears(3), "SDE-2", EmployeeStatus.ACTIVE, EmploymentType.FULLTIME);


                System.out.println(employee.getId());
                EmployeeService.add(employee);
                EmployeeService.add(employee1);
                EmployeeService.add(employee2);
                EmployeeService.add(employee3);

            } else if (Objects.equals(option, "b")) {
                System.out.println("Enter employee Id to delete");
                Scanner input = new Scanner(System.in);
                String empid = input.nextLine();
                EmployeeService.delete(empid);

            } else if (Objects.equals(option, "c")) {
                System.out.println("Enter empId and employment type");
                Scanner input = new Scanner(System.in);
                String empId = input.nextLine();
                String type = input.nextLine();
                EmployeeService.updateType(empId,type);


            } else if (Objects.equals(option, "d")) {
                System.out.println("Enter empId and role to update");
                Scanner input = new Scanner(System.in);
                String empId = input.nextLine();
                String role = input.nextLine();
                EmployeeService.updateRole(empId,role);


            } else if (Objects.equals(option, "e")) {
                System.out.println("Senior employees is/are: " + EmployeeService.findSeniorEmployee());

            } else if (option.equals("f")) {
                System.out.println("Enter status ACTIVE/SERVING NOTICE/DISMISSED");
                Scanner input = new Scanner(System.in);
                String status = input.nextLine();
                System.out.println(EmployeeService.findEmployeeByStatus(status));
            } else {
                System.out.println("Invalid Input!!");
                break;
            }
        }
        in.close();
    }
}