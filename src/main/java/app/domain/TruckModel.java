package app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Truck_Model")
public class TruckModel {
    @Id
    @Column(name="Truck_Model_ID")
    private Integer truckModelId;
    @Column(name="Truck_Brand_ID")
    private Integer truckBrandId;
    @Column(name="Truck_Model_Name")
    private String truckModelName;

    public Integer getTruckModelId() {
        return truckModelId;
    }

    public Integer getTruckBrandId() {
        return truckBrandId;
    }

    public String getTruckModelName() {
        return truckModelName;
    }
}
