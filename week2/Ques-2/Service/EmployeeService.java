package org.example.Service;

import org.example.Exceptions.EmployeeNotFound;
import org.example.Model.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmployeeService {
    private static HashMap<String, Employee> employeeHashMap = new HashMap<>();
    public static void add(Employee employee){
        employeeHashMap.put(employee.getEmployeeId(),employee);
        System.out.println(employee+ " added successfully");
    }
    public static void findById(String empId) {
        Employee employee = null;
        try {
            employee = employeeHashMap.get(empId);
            if (employee == null) throw new EmployeeNotFound("Employee Not found with this ID");

        } catch (EmployeeNotFound employeeNotFound) {
            System.out.println(employeeNotFound.getMessage());
        }
        System.out.println(employee);
    }


    public static void findEmployeesByRole(String role) {
        List<Employee> list = new ArrayList<>();

        for(Employee emp:  employeeHashMap.values()){
            if(emp.getRole().equalsIgnoreCase(role)){
                list.add(emp);
            }
        }
        if(list.isEmpty()){
            System.out.println("No employees found for the role " + role );
        }
        else System.out.println(list);

    }

    public static void findEmployeesByminexp(int minexp) {
        LocalDate date = LocalDate.now().minusYears(minexp);
        List<Employee> list = new ArrayList<>();
        for(Employee emp : employeeHashMap.values()){
            if(emp.getJoiningDate().isBefore(date)){
                list.add(emp);
            }
        }
        if(list.isEmpty()){
            System.out.println("No employees found with experience " + minexp + " years");
        }
        else{
            System.out.println(list);
        }
    }
}
