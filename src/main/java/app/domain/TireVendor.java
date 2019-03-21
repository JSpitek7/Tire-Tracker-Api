package app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tire_Vendor")
public class TireVendor {
    @Id
    @Column(name="Tire_Vendor_ID")
    private Integer tireVendorId;
    @Column(name="Tire_Vendor_Name")
    private String tireVendorName;

    public Integer getTireVendorId() {return this.tireVendorId;}
    public String getTireVendorName() {return this.tireVendorName;}

}
