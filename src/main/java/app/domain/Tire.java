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
    @Column(name="Tire_Status_ID")
    private Integer tireStatusId;
    @Column(name="Tire_Purchase_ID")
    private Integer tirePurchaseId;

    public Tire() {}

    public Tire(Integer tireModelId, String tireWarrantyId, Integer truckMileageAtInstall, Integer tireStatusId, Integer tirePurchaseId) {
        this.tireModelId = tireModelId;
        this.tireWarrantyId = tireWarrantyId;
        this.truckMileageAtInstall = truckMileageAtInstall;
        this.tireStatusId = tireStatusId;
        this.tirePurchaseId = tirePurchaseId;
    }

    public Integer getTireId() {
        return this.tireId;
    }
    public Integer getTireModelId() {return this.tireModelId;}
    public Integer getStatusId() {return this.tireStatusId;}
}
