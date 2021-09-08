package dev.shailendra.models;

public class BloodDrive {
    //Instance variables for Blood Drives
    private Integer driveId;
    private String driveName;
    private String driveAddress;


    // No Arg Constructor/ Default Constructor
    public BloodDrive(){};

    public BloodDrive(String driveName, String driveAddress) {
        this.driveName = driveName;
        this.driveAddress = driveAddress;
    }

    public BloodDrive(Integer driveId, String driveName, String driveAddress) {
        this.driveId = driveId;
        this.driveName = driveName;
        this.driveAddress = driveAddress;
    }

    public Integer getDriveId() {
        return driveId;
    }

    public void setDriveId(Integer driveId) {
        this.driveId = driveId;
    }

    public String getDriveName() {
        return driveName;
    }

    public void setDriveName(String driveName) {
        this.driveName = driveName;
    }

    public String getDriveAddress() {
        return driveAddress;
    }

    public void setDriveAddress(String driveAddress) {
        this.driveAddress = driveAddress;
    }

    @Override
    public String toString() {
        return "BloodDrives{" +
                "driveId=" + driveId +
                ", driveName='" + driveName + '\'' +
                ", driveAddress='" + driveAddress + '\'' +
                '}';
    }
}
