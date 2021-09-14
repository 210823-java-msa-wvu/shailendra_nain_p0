package dev.shailendra.models;

public class Registration {
    private int reg_id;
    private String reg_health;
    private int reg_dob;
    private String reg_approval;
    private int donor_id;
    private int drive_id;

    public Registration() {
    }

    public Registration(String reg_health, int reg_dob, String reg_approval, int donor_id, int drive_id) {
        this.reg_health = reg_health;
        this.reg_dob = reg_dob;
        this.reg_approval = reg_approval;
        this.donor_id = donor_id;
        this.drive_id = drive_id;
    }


    public Registration(int reg_id, String reg_health, int reg_dob, String reg_approval, int donor_id, int drive_id) {
        this.reg_id = reg_id;
        this.reg_health = reg_health;
        this.reg_dob = reg_dob;
        this.reg_approval = reg_approval;
        this.donor_id = donor_id;
        this.drive_id = drive_id;
    }

    public int getDonor_id() {
        return donor_id;
    }

    public void setDonor_id(int donor_id) {
        this.donor_id = donor_id;
    }

    public int getDrive_id() {
        return drive_id;
    }

    public void setDrive_id(int drive_id) {
        this.drive_id = drive_id;
    }

    public int getReg_id() {
        return reg_id;
    }

    public void setReg_id(int reg_id) {
        this.reg_id = reg_id;
    }

    public String getReg_health() {
        return reg_health;
    }

    public void setReg_health(String reg_health) {
        this.reg_health = reg_health;
    }

    public int getReg_dob() {
        return reg_dob;
    }

    public void setReg_dob(int reg_dob) {
        this.reg_dob = reg_dob;
    }

    public String getReg_approval() {
        return reg_approval;
    }

    public void setReg_approval(String reg_approval) {
        this.reg_approval = reg_approval;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "reg_id=" + reg_id +
                ", reg_health='" + reg_health + '\'' +
                ", reg_dob=" + reg_dob +
                ", reg_approval='" + reg_approval + '\'' +
                '}';
    }
}
