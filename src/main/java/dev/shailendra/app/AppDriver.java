package dev.shailendra.app;

import dev.shailendra.models.BloodDrive;
import dev.shailendra.models.Employee;
import dev.shailendra.repositories.BloodDriveRepo;
import dev.shailendra.repositories.EmployeeRepo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AppDriver {
    public static Scanner scan = new Scanner(System.in);
    private static BloodDriveRepo driveRepo = new BloodDriveRepo();
    private static EmployeeRepo employeeRepo = new EmployeeRepo();
    private static boolean appRunning = true;
    public static void main(String[] args){
        System.out.println("Welcome Employee\n1. for search by name");
        String userName = scan.nextLine();
        try{
            if(userName.equals(employeeRepo.getByName(userName).getEmpUsername())){
                System.out.println("User already found in the system");
            }
        }catch(NullPointerException e){
            e.printStackTrace();
            System.out.println("No User found you can register Here");
        }




//        init();
 //        List<BloodDrive> drives = new ArrayList<BloodDrive>(driveRepo.getAll());
//        System.out.println("================================");
//        System.out.println("Complete List of Blood Drives");
//        for (BloodDrive drive : drives) {
//            System.out.println("Id : "
//                    + drive.getDriveId()+ " | " +
//                    " Drive Name : " + drive.getDriveName()+
//                    " | " + " Drive Address : " +
//                    drive.getDriveAddress());
//        }
        scan.close();
    }

    public static void init(){
        System.out.println("Welcome to Online Blood Drive Management System");
        System.out.println("User please enter your name");
        String user = scan.nextLine();

        while(appRunning){
            System.out.println("Please enter your choice\n'1' to Enter\n '0' to quit");
            user = scan.nextLine();
            switch (user){
                case "1" : {
                     System.out.println("Enter the ID in between 1 - 16");
                            Integer id = scan.nextInt();
                            scan.nextLine();
                            getDriveDetail(id);
                            break;
                }
                case "0" : {
                    appRunning = false;
                    System.out.println("Thanks for using Online Blood Donation System!");
                    break;
                }

            }
        }
    }

    public static void getDriveDetail(Integer id){
        if(id != null){
            String address = driveRepo.getById(id).getDriveAddress();
            String name = driveRepo.getById(id).getDriveName();
            System.out.println("================================");
            System.out.println("Drive Name : " + name + "|" + " Address : " + address);
            System.out.println("================================");
        }else{
            System.out.println("Not a Valid UserId");
        }
    }
}
