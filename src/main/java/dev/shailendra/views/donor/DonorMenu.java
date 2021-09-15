package dev.shailendra.views.donor;

import dev.shailendra.exceptions.NullPointerException;
import dev.shailendra.models.BloodDrive;
import dev.shailendra.models.Donor;
import dev.shailendra.models.Employee;
import dev.shailendra.models.Registration;
import dev.shailendra.repositories.BloodDriveRepo;
import dev.shailendra.repositories.DonorRepo;
import dev.shailendra.repositories.RegistrationRepo;
import dev.shailendra.services.DonorServices;
import dev.shailendra.services.EmployeeServices;
import dev.shailendra.services.BloodDriveServices;
import org.postgresql.util.PSQLException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import java.util.Scanner;

public class DonorMenu {
        private static BloodDriveRepo bloodDriveRepo = new BloodDriveRepo();
        private static DonorServices donorServices = new DonorServices();
        private static DonorRepo donorRepo = new DonorRepo();
        private static RegistrationRepo registrationRepo = new RegistrationRepo();

        public static void donorMenu(String userInput) {
                Scanner scan = new Scanner(System.in);
                boolean appRun = true;
                if (userInput.equals("1")) {
                        System.out.println("Please Enter your Username:");
                        String userName = scan.nextLine();
                        System.out.println("Please Enter you password:");
                        String password = scan.nextLine();
                        boolean signInResponse = DonorServices.login(userName, password);
                        if (signInResponse) {
                                System.out.println("Successfully Logged In");
                                while (appRun) {
                                        System.out.println("Please choose the following:" +
                                                "\n 1) Register for Blood Donation" +
                                                "\n 2) Update Donor Name" +
                                                "\n 3) Check Approval" +
                                                "\n 4) Logout");
                                        userInput = scan.nextLine();
                                        switch (userInput) {
                                                case "1":

                                                    EmployeeServices.listAllDrives();
                                                        System.out.println("Please Enter Yes/No for Health");
                                                        String health = scan.nextLine();
                                                        System.out.println("Please Enter your age");
                                                        int age = scan.nextInt();
                                                        scan.nextLine();
                                                        String registerDefaultValue = "Pending";
                                                        int donorID = donorRepo.getByUsername(userName).getDonorId();
                                                        System.out.println("Please Select the Drive Id");
                                                        int driveID = scan.nextInt();
                                                        scan.nextLine();
                                                        Registration registration = new Registration(health, age, registerDefaultValue, donorID, driveID);
                                                        registrationRepo.add(registration);

                                                        break;

                                                case "2":

                                                       donorID = donorRepo.getByUsername(userName).getDonorId();
                                                        System.out.println("Please Enter your First Name");
                                                        String firstName = scan.nextLine();
                                                        System.out.println("Please Enter your Last Name");
                                                        String lastName = scan.nextLine();
                                                        Donor update = donorServices.updateDoninfo(donorID,firstName,lastName);
                                                        donorRepo.update(update);

                                                        String donorFirstName = donorRepo.getById(donorID).getDonFirstName();
                                                        String donorLastName = donorRepo.getById(donorID).getDonLastName();
                                                        System.out.println("Details updated : " + donorFirstName +" "+ donorLastName);
                                                        break;
                                                case "3":
                                                        System.out.println("System Processing");
                                                        List<Registration> reg = new ArrayList<>(registrationRepo.getAll());
                                                        String approval = "";
                                                        for (Registration r : reg){
                                                               approval =  r.getReg_approval();
                                                        }
                                                        System.out.println("Status of your Registration : " + approval +"\n\n");
                                                        break;
                                                case "4" :
                                                        appRun = false;
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

        public static void listAllDrives(){
                List<BloodDrive> bloodDriveList = new ArrayList<>(bloodDriveRepo.getAll());
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


