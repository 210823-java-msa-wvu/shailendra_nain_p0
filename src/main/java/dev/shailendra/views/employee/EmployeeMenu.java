package dev.shailendra.views.employee;

import dev.shailendra.models.BloodDrive;
import dev.shailendra.models.Donor;
import dev.shailendra.models.Employee;
import dev.shailendra.models.Registration;
import dev.shailendra.repositories.BloodDriveRepo;
import dev.shailendra.repositories.DonorRepo;
import dev.shailendra.repositories.EmployeeRepo;
import dev.shailendra.repositories.RegistrationRepo;
import dev.shailendra.services.EmployeeServices;
import dev.shailendra.services.BloodDriveServices;
import dev.shailendra.services.RegistrationServices;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import java.util.Scanner;

public class EmployeeMenu {
    private static EmployeeServices es = new EmployeeServices();
    private static BloodDriveServices bds = new BloodDriveServices();
    private static BloodDrive bloodDrive = new BloodDrive();
    private static BloodDriveRepo driveRepo = new BloodDriveRepo();
    private static EmployeeRepo employeeRepo = new EmployeeRepo();
    private static DonorRepo donorRepo = new DonorRepo();
    private static RegistrationRepo registrationRepo = new RegistrationRepo();
    private static RegistrationServices registrationServices = new RegistrationServices();


    public static void employeeMenu(String userInput) {
        Scanner scan = new Scanner(System.in);
        boolean empRun = true;
        if (userInput.equals("1")) {
            System.out.println("Please Enter your Username:");
            String userName = scan.nextLine();
            System.out.println("Please Enter you password:");
            String password = scan.nextLine();
            boolean signInResponse = es.login(userName, password);
            if (signInResponse) {
                System.out.println("Successfully Logged In");
                while (empRun) {
                    System.out.println("Please choose the following:" +
                            "\n 1) Create a New Blood Drive." +
                            "\n 2) Update an Existing Blood Drive." +
                            "\n 3) Delete a Blood Drive." +
                            "\n 4) List All Blood Drives" +
                            "\n 5) Donor Application" +
                            "\n 6) Update Employee Name" +
                            "\n 7) Logout");
                    userInput = scan.nextLine();
                    switch (userInput) {
                        case "1":
                            System.out.println("Please enter the Drive Name : ");
                            String driveName = scan.nextLine();
                            System.out.println("Please enter the Address : ");
                            String driveAddress = scan.nextLine();
                            driveRepo.add(bds.saveDriveData(driveName, driveAddress));
                            System.out.println("Successfully Added Blood Drive");
                            System.out.println();
                            break;

                        case "2":
                            EmployeeServices.listAllDrives();
                            System.out.println("Select Drive Id to Update");
                            int input = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Please enter the Drive Name : ");
                            String updateDriveName = scan.nextLine();
                            System.out.println("Please enter the Address : ");
                            String updateDriveAddress = scan.nextLine();
                            BloodDrive updateData = new BloodDrive(input,updateDriveName,updateDriveAddress);
                            driveRepo.update(updateData);
                            System.out.println("Drive Id " + input + " updated");
                            break;
                        case "3":
                            EmployeeServices.listAllDrives();
                             try{
                                 System.out.println("Please Enter the ID");
                                 input = scan.nextInt();
                                if(es.checkId(input)) {
                                    driveRepo.delete(input);
                                    System.out.println("Drive Id " + input + " deleted\n");
                                    scan.nextLine();
                                }
                            }catch(NullPointerException | InputMismatchException e){
                                System.out.println("Please Enter a valid id\n\n");
                                scan.nextLine();

                        }break;

                        case "4":
                                EmployeeServices.listAllDrives();
                            break;
                        case "5":
                            System.out.println("Details of Applicants registered for Donations\n");
                                registrationRepo.getAllDetails();
                            System.out.println("Please choose an ID");
                            int inputId = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Please Enter Approve/Deny");
                            String approval = scan.nextLine();
                            Registration registration = registrationServices.updateApproval(inputId, approval);
                            registrationRepo.update(registration);
                            registrationRepo.getAllDetailsByID(inputId);
                            break;
                        case "6" :
                            System.out.println("Please select your ID");
                            int id = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Please Enter your First Name");
                            String newFirstName = scan.nextLine();
                            System.out.println("Please Enter your Last Name");
                            String newLastName = scan.nextLine();
                            Employee update = es.updateEmpinfo(id,newFirstName,newLastName);
                            employeeRepo.update(update);

                            break;
                        case "7" :
                            System.out.println("Logout\n");
                            empRun = false;
                            break;
                        default :
                            System.out.println("Please enter a valid number");
                        break;
                    }
                }
            } else {
                System.out.println("Credential does not match");
            }
        }
    }
}
