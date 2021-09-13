package dev.shailendra.views.employee;


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
    private static EmployeeServices es = new EmployeeServices();
    private static BloodDriveServices bds = new BloodDriveServices();
    private static BloodDrive bloodDrive = new BloodDrive();
    private static BloodDriveRepo driveRepo = new BloodDriveRepo();
    private static EmployeeRepo employeeRepo = new EmployeeRepo();
    private static DonorRepo donorRepo = new DonorRepo();



    public static void subMenu(String input) {
        Scanner scan = new Scanner(System.in);
            System.out.println("Enter your First Name");
            String firstName = scan.nextLine();
            System.out.println("Enter your Last Name");
            String lastName = scan.nextLine();
            System.out.println("Enter your User Name");
            String userName = scan.nextLine();
            System.out.println("Enter Password");
            String password = scan.nextLine();
            Employee em = new Employee(firstName,lastName,userName, password);
            employeeRepo.add(em);
        System.out.println("User Created");
        }
    }

