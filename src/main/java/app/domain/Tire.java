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

    public Tire() {}

    public Tire(Integer tireModelId, String tireWarrantyId, Integer truckMileageAtInstall, Integer tireStatusId) {
        this.tireModelId = tireModelId;
        this.tireWarrantyId = tireWarrantyId;
        this.truckMileageAtInstall = truckMileageAtInstall;
        this.tireStatusId = tireStatusId;
    }

    public Integer getTireId() {
        return this.tireId;
    }
}
