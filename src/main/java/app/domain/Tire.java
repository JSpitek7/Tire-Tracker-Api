package app.domain;

import javax.persistence.*;


@Entity
@Table(name="Tire")
public class Tire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Tire_ID")
    private Integer tireId;
    @Column(name="Tire_Model_ID")
    private Integer tireModelId;
    @Column(name="Tire_Warranty_ID")
    private String tireWarrantyId;
    @Column(name="Truck_Mileage_At_Install")
    private Integer truckMileageAtInstall;
    @Column(name="Truck_Mileage_At_Removal")
    private Integer truckMileageAtRemoval;
    @Column(name="Tire_Status_ID")
    private Integer tireStatusId;
    @Column(name="Tire_Purchase_ID")
    private Integer tirePurchaseId;

    public Integer getTireId() {
        return this.tireId;
    }
    public Integer getTireModelId() {return this.tireModelId;}
    public Integer getStatusId() {return this.tireStatusId;}

    public void setTruckMileageAtInstall(Integer truckMileageAtInstall) {
        this.truckMileageAtInstall = truckMileageAtInstall;
    }

    public void setTruckMileageAtRemoval(Integer truckMileageAtRemoval) {
        this.truckMileageAtRemoval = truckMileageAtRemoval;
    }

    public void setTireStatusId(Integer tireStatusId) {
        this.tireStatusId = tireStatusId;
    }

    public Tire() {}

    public Tire(Integer tireModelId, String tireWarrantyId, Integer truckMileageAtInstall, Integer truckMileageAtRemoval, Integer tireStatusId, Integer tirePurchaseId) {
        this.tireModelId = tireModelId;
        this.tireWarrantyId = tireWarrantyId;
        this.truckMileageAtInstall = truckMileageAtInstall;
        this.truckMileageAtRemoval = truckMileageAtRemoval;
        this.tireStatusId = tireStatusId;
        this.tirePurchaseId = tirePurchaseId;
    }


}
