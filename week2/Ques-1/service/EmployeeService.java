package org.example.service;

import org.example.exception.EmployeeNotFound;
import org.example.exception.EmployeeTypeNotFound;
import org.example.model.Employee;
import org.example.model.EmployeeStatus;
import org.example.model.EmploymentType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.example.model.EmployeeStatus.DISMISSED;

public class EmployeeService {
    private static HashMap<String, Employee> employeeHashMap = new HashMap<>();
    public static void add(Employee employee){
        employeeHashMap.put(employee.getId(),employee);
        System.out.println(employee + "   Added successfully !!!!");
    }
    public static void delete(String id){

            Employee employee = employeeHashMap.get(id);
            if(employee == null){
                System.out.println("Employee not found with this ID: " + id);
            }
            else{
                employee.setEmployeeStatus(DISMISSED);
                employeeHashMap.put(id,employee);
                System.out.println("Employee deleted successfully");
            }

    }
    public static void updateType(String id,String type){
        try {
            Employee employee = employeeHashMap.get(id);
            if(employee == null){
                System.out.println("Employee with the given ID is not found");
            }
            else {
                boolean flag = false;
                for (EmploymentType value : EmploymentType.values()) {
                    if (value.toString().equalsIgnoreCase(type)) {
                        employee.setEmploymentType(value);
                        flag = true;
                        employeeHashMap.put(id, employee);
                        System.out.println(employee + " Changed Employment type successfully");
                    }
                }
                if (!flag) {
                    throw new EmployeeTypeNotFound("The type you have entered is wrong or not found");
                }
            }

        }catch (EmployeeTypeNotFound employeeTypeNotFound){
            System.out.println(employeeTypeNotFound.getMessage());
        }

    }
    public static void updateRole(String id,String role){
        Employee employee = employeeHashMap.get(id);
        try{
            if(employee != null){
                employee.setRole(role);
                employeeHashMap.put(id,employee);
                System.out.println(employee + "Updated Role successfully");
            }
            else throw new EmployeeNotFound( "Employee not found exception");
        }
        catch (EmployeeNotFound e){
            System.out.println(e.getMessage());
        }

    }
    public static List<Employee> findSeniorEmployee(){
        List<Employee> employeeList=new ArrayList<>();
        LocalDate oldDate = LocalDate.now();
        try{
            for(Employee employee: employeeHashMap.values()){
                if(employee.getJoiningDate().isBefore(oldDate) && !employee.getEmployeeStatus().equals(DISMISSED)){
                    oldDate = employee.getJoiningDate();
                }
            }
            for(Employee employee: employeeHashMap.values()){
                if(employee.getJoiningDate().equals(oldDate)){
                    employeeList.add(employee);
                }
            }
        }
        catch (RuntimeException e){
            System.out.println("Exception in hashmap");
        }
        return employeeList;
    }
    public static List<Employee> findEmployeeByStatus(String status){

        List<Employee> employeeList=new ArrayList<>();
            for(Employee employee:employeeHashMap.values()){
                if(employee.getEmployeeStatus().toString().equalsIgnoreCase(status)) {
                    employeeList.add(employee);
                }
            }
        return employeeList;
    }
}
