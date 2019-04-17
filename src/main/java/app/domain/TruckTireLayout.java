package app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Truck_Tire_Layout")
public class TruckTireLayout {
    @Id
    @Column(name="Truck_Tire_Layout_ID")
    private Integer truckTireLayoutId;
    @Column(name="Truck_Tire_Layout_Picture")
    private String truckTireLayoutPicture;
}
