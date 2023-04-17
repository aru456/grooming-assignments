package org.example.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String employeeId;
    private String name;
    private LocalDate joiningDate;
    private EmployeType employeType;
    private String role;
    private String domain;


}
