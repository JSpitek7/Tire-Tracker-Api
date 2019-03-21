package app.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Employee_Type")
public class EmployeeType {
    @Id
    @Column(name="Emp_Type_ID")
    private Integer empTypeId;
    @Column(name="Emp_Type_Title")
    private String empTypeTitle;

    public Integer getEmpTypeId() {return this.empTypeId;}
    public String getEmpTypeTitle() {return this.empTypeTitle;}
}
