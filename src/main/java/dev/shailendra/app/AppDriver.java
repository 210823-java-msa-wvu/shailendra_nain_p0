package dev.shailendra.app;

import dev.shailendra.repositories.BloodDriveRepo;
import dev.shailendra.repositories.DonorRepo;
import dev.shailendra.repositories.EmployeeRepo;
import dev.shailendra.repositories.RegistrationRepo;
import dev.shailendra.services.BloodDriveServices;
import dev.shailendra.services.EmployeeServices;
import dev.shailendra.views.donor.DonorMenu;
import dev.shailendra.views.employee.EmployeeMenu;
import dev.shailendra.views.employee.EmployeeSubMenu;
import dev.shailendra.views.donor.DonorSubMenu;
import java.util.Scanner;



public class AppDriver {
    public static Scanner scan = new Scanner(System.in);


    private static boolean appRunning = true;

    public static void main(String[] args) {
        while(appRunning){
            System.out.println("Welcome To Online Blood Donation System\n");

            System.out.println("Please Enter.. \n1.Manager\n2.Donor\n3.Quit");
            String userInput = scan.nextLine();
            switch(userInput){
                case "1" :
                    System.out.println("Employee can Login/Register.\n 1) Login \n 2) Register");
                    userInput = scan.nextLine();
                    switch(userInput){
                        case "1" :
                            EmployeeMenu.employeeMenu(userInput);
                            break;
                        case "2" :
                            EmployeeSubMenu.subMenu();
                            break;
                    }
                    break;
                case "2" :
                    System.out.println("Donor Login/Register.\n 1) Login \n 2) Register");
                        userInput = scan.nextLine();
                        switch (userInput){
                            case "1" :
                                    DonorMenu.donorMenu(userInput);
                                break;
                            case "2" :
                                    DonorSubMenu.donorRegistration();
                                break;
                        }

                    break;
                case "3" :
                    System.out.println("Thank You!");
                    appRunning = false;
                    break;
                default :
                    System.out.println("Please enter a valid value");
                    break;
            }

            }
        }


    }



