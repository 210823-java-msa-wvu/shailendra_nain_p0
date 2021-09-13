package dev.shailendra.services;


import dev.shailendra.models.BloodDrive;
import dev.shailendra.repositories.BloodDriveRepo;

public class BloodDriveServices {
    BloodDriveRepo bd = new BloodDriveRepo();

    public BloodDrive saveDriveData(String driveName, String driveAddress){
        BloodDrive bd = new BloodDrive(driveName, driveAddress);
        return bd;
    }


}
