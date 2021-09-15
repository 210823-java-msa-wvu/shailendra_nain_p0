package dev.shailendra.services;

import dev.shailendra.models.BloodDrive;
import dev.shailendra.models.Employee;
import dev.shailendra.models.Registration;
import dev.shailendra.repositories.BloodDriveRepo;
import dev.shailendra.repositories.EmployeeRepo;
import dev.shailendra.repositories.RegistrationRepo;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServices {
    private static BloodDriveRepo driveRepo = new BloodDriveRepo();
    private static EmployeeRepo employeeRepo = new EmployeeRepo();
    private static RegistrationRepo registrationRepo = new RegistrationRepo();

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

    public boolean checkDriveID(int input){
        BloodDrive drive = driveRepo.getById(input);
        if(drive.getDriveId() == input){
            return true;
        }else if(input != drive.getDriveId()) {
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

    public static void listAllDrives(){
        List<BloodDrive> bloodDriveList = new ArrayList<>(driveRepo.getAll());
        System.out.println("Drives Names & Address :");
        for (BloodDrive drive : bloodDriveList){
            Integer driveId = drive.getDriveId();
            String dName = drive.getDriveName();
            String dAddress = drive.getDriveAddress();
            System.out.println(
                    "ID : " + driveId +
                            " | Drive Name : " + dName +
                            " | Address : " + dAddress);
        }
    }

}
