package app.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class EmployeeDto {
    private boolean foundUser;
    private Integer empId;
    private String empName;
    private String empPhone;
    private String empEmail;
    private String empType;

    public boolean getFoundUser() { return foundUser; }
    public Integer getEmpId() { return empId; }
    public String getEmpName() {
        return empName;
    }
    public String getEmpPhone() {
        return empPhone;
    }
    public String getEmpEmail() {
        return empEmail;
    }
    public String getEmpType() {
        return empType;
    }

    public EmployeeDto(Integer empId, String empName, String empPhone, String empEmail, String empType) {
        this.foundUser = true;
        this.empId = empId;
        this.empName = empName;
        this.empPhone = empPhone;
        this.empEmail = empEmail;
        this.empType = empType;
    }

    public EmployeeDto(boolean foundUser){
        this.foundUser=foundUser;
    }
}
