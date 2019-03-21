package app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tire_Model")
public class TireModel {
    @Id
    @Column(name="Tire_Model_ID")
    private Integer tireModelId;
    @Column(name="Tire_Brand_ID")
    private Integer tireBrandId;
    @Column(name="Tire_Vendor_ID")
    private Integer tireVendorId;
    @Column(name="Tire_Model_Name")
    private String tireModelName;
    @Column(name="Tire_Price")
    private Integer tirePrice;
    @Column(name="Tire_Tread_Depth")
    private Integer tireTreadDepth;
    @Column(name="Tire_Total_Miles_Driven")
    private Integer tireTotalMilesDriven;
    @Column(name="Tire_Total_Number_Used")
    private Integer tireTotalNumberUsed;
    @Column(name="Tire_Weight_LBS")
    private Integer tireTotalWeightLbs;
    public Integer getTireModelId() {
        return tireModelId;
    }

    public Integer getTireBrandId() {return tireBrandId;}

    public Integer getTireVendorId() {
        return tireVendorId;
    }

    public String getTireModelName() {
        return tireModelName;
    }

    public Integer getTirePrice() {
        return tirePrice;
    }

    public Integer getTireTreadDepth() {
        return tireTreadDepth;
    }

    public Integer getTireTotalMilesDriven() {
        return tireTotalMilesDriven;
    }

    public Integer getTireTotalNumberUsed() {
        return tireTotalNumberUsed;
    }

    public Integer getTireTotalWeightLbs() {
        return tireTotalWeightLbs;
    }
}
