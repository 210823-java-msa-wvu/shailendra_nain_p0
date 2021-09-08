package dev.shailendra.models;

public class Registration {
    private Integer regId;
    private String regHealth;
    private String regDOB;
    private String regStatus;

    public Registration() {
    }

    public Registration(String regHealth, String regDOB, String regStatus) {
        this.regHealth = regHealth;
        this.regDOB = regDOB;
        this.regStatus = regStatus;
    }

    public Registration(Integer regId, String regHealth, String regDOB, String regStatus) {
        this.regId = regId;
        this.regHealth = regHealth;
        this.regDOB = regDOB;
        this.regStatus = regStatus;
    }

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public String getRegHealth() {
        return regHealth;
    }

    public void setRegHealth(String regHealth) {
        this.regHealth = regHealth;
    }

    public String getRegDOB() {
        return regDOB;
    }

    public void setRegDOB(String regDOB) {
        this.regDOB = regDOB;
    }

    public String getRegStatus() {
        return regStatus;
    }

    public void setRegStatus(String regStatus) {
        this.regStatus = regStatus;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "regId=" + regId +
                ", regHealth='" + regHealth + '\'' +
                ", regDOB='" + regDOB + '\'' +
                ", regStatus='" + regStatus + '\'' +
                '}';
    }
}
