package dev.shailendra.services;

import dev.shailendra.exceptions.NullPointerException;
import dev.shailendra.exceptions.PSQLException;
import dev.shailendra.models.BloodDrive;
import dev.shailendra.models.Donor;
import dev.shailendra.models.Employee;
import dev.shailendra.repositories.BloodDriveRepo;
import dev.shailendra.repositories.DonorRepo;

public class DonorServices {
    static DonorRepo donorRepo = new DonorRepo();
    static BloodDriveRepo driveRepo = new BloodDriveRepo();

    public static boolean login(String username, String password){
        Donor d = donorRepo.getByUsername(username);
        if(d != null){
            if(username.equals(d.getDonUsername()) && password.equals(d.getDonPassword())){
                return true;
            }
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


    public Donor updateDoninfo(int id , String firstname, String lastname){
        Donor d = new Donor();
        d.setDonorId(id);
        d.setDonFirstName(firstname);
        d.setDonLastName(lastname);

        return d;
    }
}
