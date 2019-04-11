package app.domain;
import javax.persistence.*;

@Entity
@Table (name="Employee")
public class Employee {
    @Id
    @Column(name="Emp_ID")
    private Integer empId;
    @Column(name="Emp_Type_ID")
    private Integer empTypeId;
    @Column(name="Emp_F_Name")
    private String empFName;
    @Column (name="Emp_M_Name")
    private String empMName;
    @Column (name="Emp_L_Name")
    private String empLName;
    @Column (name="Emp_Phone_Num")
    private String empPhoneNum;
    @Column (name="Emp_Email_Addr")
    private String empEmail;
    @Column (name="Emp_Username")
    private String empUsername;
    @Column (name="Emp_Password")
    private String empPassword;
    @Column (name="Emp_Address_ID")
    private String empAddressId;

    public Integer getEmpId() {
        return empId;
    }

    public Integer getEmpTypeId() {
        return empTypeId;
    }

    public String getEmpFName() {
        return empFName;
    }

    public String getEmpMName() {
        return empMName;
    }

    public String getEmpLName() {
        return empLName;
    }

    public String getEmpPhoneNum() {
        return empPhoneNum;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public String getEmpUsername() {
        return empUsername;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public String getEmpAddressId() {
        return empAddressId;
    }
}
