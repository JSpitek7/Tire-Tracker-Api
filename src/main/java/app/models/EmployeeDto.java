package app.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class EmployeeDto {
    private Integer empId;
    private String empName;
    private String empPhone;
    private String empEmail;

    public Integer getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public EmployeeDto(Integer empId, String empName, String empPhone, String empEmail) {
        this.empId = empId;
        this.empName = empName;
        this.empPhone = empPhone;
        this.empEmail = empEmail;
    }
}
