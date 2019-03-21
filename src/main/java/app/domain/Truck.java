package app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Truck")
public class Truck {
    @Id
    @Column(name="Truck_ID")
    private Integer truckId;
    @Column(name="Truck_Driver_Emp_ID")
    private Integer truckDriverEmpId;
    @Column(name="Truck_Model_ID")
    private Integer truckModelId;
    @Column(name="Truck_VIN")
    private String TruckVin;

    public Integer getTruckId() {
        return truckId;
    }

    public Integer getTruckDriverEmpId() {
        return truckDriverEmpId;
    }

    public Integer getTruckModelId() {
        return truckModelId;
    }

    public String getTruckVin() {
        return TruckVin;
    }
}
