package dev.shailendra.models;

public class Donor {

    private Integer donorId;
    private String donFirstName;
    private String donLastName;
    private String donUsername;
    private String donPassword;

    public Donor() {
    }

    public Donor(String donFirstName, String donLastName, String donUsername, String donPassword) {
        this.donFirstName = donFirstName;
        this.donLastName = donLastName;
        this.donUsername = donUsername;
        this.donPassword = donPassword;
    }

    public Donor(Integer donorId, String donFirstName, String donLastName, String donUsername, String donPassword) {
        this.donorId = donorId;
        this.donFirstName = donFirstName;
        this.donLastName = donLastName;
        this.donUsername = donUsername;
        this.donPassword = donPassword;
    }

    public Integer getDonorId() {
        return donorId;
    }

    public void setDonorId(Integer donorId) {
        this.donorId = donorId;
    }

    public String getDonFirstName() {
        return donFirstName;
    }

    public void setDonFirstName(String donFirstName) {
        this.donFirstName = donFirstName;
    }

    public String getDonLastName() {
        return donLastName;
    }

    public void setDonLastName(String donLastName) {
        this.donLastName = donLastName;
    }

    public String getDonUsername() {
        return donUsername;
    }

    public void setDonUsername(String donUsername) {
        this.donUsername = donUsername;
    }

    public String getDonPassword() {
        return donPassword;
    }

    public void setDonPassword(String donPassword) {
        this.donPassword = donPassword;
    }

    @Override
    public String toString() {
        return "Donors{" +
                "donorId=" + donorId +
                ", donFirstName='" + donFirstName + '\'' +
                ", donLastName='" + donLastName + '\'' +
                ", donUsername='" + donUsername + '\'' +
                ", donPassword='" + donPassword + '\'' +
                '}';
    }
}
