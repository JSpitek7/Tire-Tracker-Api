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
    @Column(name="Tire_Model_Tread_Depth")
    private Integer tireModelTreadDepth;
    @Column(name="Tire_Model_Total_Miles_Driven")
    private Integer tireModelTotalMilesDriven;
    @Column(name="Tire_Model_Weight_LBS")
    private Integer tireModelTotalWeightLbs;

    public Integer getTireModelId() {
        return tireModelId;
    }

    public Integer getTireBrandId() {
        return tireBrandId;
    }

    public Integer getTireVendorId() {
        return tireVendorId;
    }

    public String getTireModelName() {
        return tireModelName;
    }

    public Integer getTireModelTreadDepth() {
        return tireModelTreadDepth;
    }

    public Integer getTireModelTotalMilesDriven() {
        return tireModelTotalMilesDriven;
    }

    public Integer getTireModelTotalWeightLbs() {
        return tireModelTotalWeightLbs;
    }
}
