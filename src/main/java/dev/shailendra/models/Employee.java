package dev.shailendra.models;

public class Employee {
    private Integer employeeId;
    private String empFirstName;
    private String empLastName;
    private String empUsername;
    private String empPassword;

    public Employee() {
    }

    public Employee(String empFirstName, String empLastName, String empUsername, String empPassword) {
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
        this.empUsername = empUsername;
        this.empPassword = empPassword;
    }

    public Employee(Integer employeeId, String empFirstName, String empLastName, String empUsername, String empPassword) {
        this.employeeId = employeeId;
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
        this.empUsername = empUsername;
        this.empPassword = empPassword;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public String getEmpUsername() {
        return empUsername;
    }

    public void setEmpUsername(String empUsername) {
        this.empUsername = empUsername;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employeeId=" + employeeId +
                ", empFirstName='" + empFirstName + '\'' +
                ", empLastName='" + empLastName + '\'' +
                ", empUsername='" + empUsername + '\'' +
                ", empPassword='" + empPassword + '\'' +
                '}';
    }
}
