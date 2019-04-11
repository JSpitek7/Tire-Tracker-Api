package app.domain;

import javax.persistence.*;

@Entity
@Table(name="Truck")
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Truck_ID")
    private Integer truckId;
    @Column(name="Truck_Driver_Emp_ID")
    private Integer truckDriverEmpId;
    @Column(name="Truck_Model_ID")
    private Integer truckModelId;
    @Column(name="Truck_License_Plate_Number")
    private String truckLicensePlateNumber;
    @Column(name="Truck_Tire_Layout_ID")
    private Integer truckTireLayoutId;

    public Truck() {}

    public Truck(Integer truckDriverEmpId, Integer truckModelId, String truckLicensePlateNumber, Integer truckTireLayoutId) {
        this.truckDriverEmpId = truckDriverEmpId;
        this.truckModelId = truckModelId;
        this.truckLicensePlateNumber = truckLicensePlateNumber;
        this.truckTireLayoutId = truckTireLayoutId;
    }

    public Integer getTruckId() {
        return truckId;
    }

    public Integer getTruckDriverEmpId() {
        return truckDriverEmpId;
    }

    public Integer getTruckModelId() {
        return truckModelId;
    }

    public String getTruckLicensePlateNumber() {
        return truckLicensePlateNumber;
    }

    public Integer getTruckTireLayoutId() { return this.truckTireLayoutId;}
}
