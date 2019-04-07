package app.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Address")
public class Address {
    @Id
    @Column(name="Address_ID")
    private Integer addressId;
    @Column(name="Street_Number")
    private Integer streetNumber;
    @Column(name="Street_Name")
    private String streetName;
    @Column(name="City")
    private String city;
    @Column(name="State")
    private String state;
    @Column(name="Zip_Code")
    private Integer zipCode;
}
