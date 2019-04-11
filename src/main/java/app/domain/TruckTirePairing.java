package app.domain;

import javax.persistence.*;

@Entity
@Table(name="Truck_Tire_Pairing")
public class TruckTirePairing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TT_Pairing_ID")
    private Integer truckTirePairingId;
    @Column(name="Truck_ID")
    private Integer truckId;
    @Column(name="Tire_ID")
    private Integer tireId;
    @Column(name="Tire_Position_Index")
    private Integer tirePositionIndex;

    public Integer getTruckTirePairingId() {
        return this.truckTirePairingId;
    }
    public Integer getTireId() { return this.truckId;}

    public void setTireId(Integer tireId) {
        this.tireId = tireId;
    }

    public TruckTirePairing() {}

    public TruckTirePairing(Integer truckId, Integer tireId, Integer tirePositionIndex) {
        this.truckId = truckId;
        this.tireId = tireId;
        this.tirePositionIndex = tirePositionIndex;
    }
}
