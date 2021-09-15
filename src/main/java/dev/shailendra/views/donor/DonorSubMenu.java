package dev.shailendra.views.donor;

import dev.shailendra.exceptions.NullPointerException;
import dev.shailendra.models.Donor;
import dev.shailendra.repositories.DonorRepo;

import java.sql.SQLOutput;
import java.util.Scanner;

public class DonorSubMenu {
    private static DonorRepo donorRepo = new DonorRepo();

    public static void donorRegistration() {

            Scanner scan = new Scanner(System.in);
            System.out.println("Welcome to Donor Registration\n");
            System.out.println("Please Enter your First Name");
            String firstname = scan.nextLine();

            System.out.println("please Enter your Last Name");
            String lastName = scan.nextLine();

            System.out.println("Please Enter your Username");
            String username = scan.nextLine();

            System.out.println("Please Enter your Password");
            String password = scan.nextLine();

            Donor donor = new Donor(firstname, lastName, username, password);
            donorRepo.add(donor);
            scan.nextLine();


    }
}
