package dev.shailendra.views.employee;


import dev.shailendra.exceptions.NullPointerException;
import dev.shailendra.models.BloodDrive;
import dev.shailendra.models.Donor;
import dev.shailendra.models.Employee;
import dev.shailendra.repositories.BloodDriveRepo;
import dev.shailendra.repositories.DonorRepo;
import dev.shailendra.repositories.EmployeeRepo;
import dev.shailendra.services.EmployeeServices;
import dev.shailendra.services.BloodDriveServices;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import java.util.Scanner;
public class EmployeeSubMenu {
    private static EmployeeRepo employeeRepo = new EmployeeRepo();



// Employee Registration Menu
    public static void subMenu() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your First Name");
            String firstName = scan.nextLine();
            System.out.println("Enter your Last Name");
            String lastName = scan.nextLine();
            System.out.println("Enter your User Name");
            String userName = scan.nextLine();
            System.out.println("Enter Password");
            String password = scan.nextLine();
            if(firstName != null && lastName != null && userName != null && password != null) {
                if (!firstName.isEmpty() && !lastName.isEmpty() && !userName.isEmpty() && !password.isEmpty()) {
                    Employee em = new Employee(firstName, lastName, userName, password);
                    employeeRepo.add(em);
                    System.out.println("User Created");
                }
            }throw new NullPointerException("User Entered Invalid/Null Values");
        }catch(NullPointerException e){
            System.out.println("Message : " + e.getMessage());
        }
        }
    }

