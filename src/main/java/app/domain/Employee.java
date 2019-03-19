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

    public Integer getEmpId() {return this.empId;}
    public Integer getEmpTypeId() {return this.empTypeId;}
    public String getEmpFName() {return this.empFName;}
    public String getEmpMName() {return this.empMName;}
    public String getEmpLName() {return this.empLName;}
    public String getEmpPhoneNum() {return this.empPhoneNum;}
    public String getEmpEmail() {return this.empEmail;}
    public String getEmpUsername() {return this.empUsername;}
    public String getEmpPassword() {return this.empPassword;}
}
