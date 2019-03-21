package app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Truck_Brand")
public class TruckBrand {
    @Id
    @Column(name="Truck_Brand_ID")
    private Integer truckBrandId;
    @Column(name="Truck_Brand_Name")
    private String truckBrandName;

    public Integer getTruckBrandId() {
        return truckBrandId;
    }

    public String getTruckBrandName() {
        return truckBrandName;
    }
}
