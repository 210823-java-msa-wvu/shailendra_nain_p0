package dev.shailendra.services;

import dev.shailendra.models.BloodDrive;
import dev.shailendra.models.Employee;
import dev.shailendra.repositories.EmployeeRepo;

public class EmployeeServices {
    EmployeeRepo employeeRepo = new EmployeeRepo();
    BloodDrive bloodDrive = new BloodDrive();
    public boolean login(String username, String password){
        Employee e = employeeRepo.getByUsername(username);
        if(e != null){
            if(username.equals(e.getEmpUsername()) && password.equals(e.getEmpPassword())){
                return true;
            }
        }
        return false;
    }

    public boolean checkId(int input){
        Employee id = employeeRepo.getById(input);
       if(id.getEmployeeId() == input){
            return true;
        }else if(input != id.getEmployeeId()){
           return false;
       }
        return false;
    }

    public Employee updateEmpinfo(int id , String firstname, String lastname){
        Employee emp = new Employee();
        emp.setEmployeeId(id);
        emp.setEmpFirstName(firstname);
        emp.setEmpLastName(lastname);
        return emp;
    }
}
