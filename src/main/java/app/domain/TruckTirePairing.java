package app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Truck_Tire_Pairing")
public class TruckTirePairing {
    @Id
    @Column(name="TT_Pairing_ID")
    private Integer truckTypePairingId;
    @Column(name="Truck_ID")
    private Integer truckId;
    @Column(name="Tire_Model_ID")
    private Integer tireModelId;
    @Column(name="Tire_Position_Index")
    private Integer tirePositionIndex;
    @Column(name="Truck_Mileage_At_Install")
    private Integer truckMileageAtInstall;

    public TruckTirePairing(){};
    public TruckTirePairing(Integer truckTypePairingId, Integer truckId, Integer tireModelId, Integer tirePositionIndex, Integer truckMileageAtInstall) {
        this.truckTypePairingId = truckTypePairingId;
        this.truckId = truckId;
        this.tireModelId = tireModelId;
        this.tirePositionIndex = tirePositionIndex;
        this.truckMileageAtInstall = truckMileageAtInstall;
    }

    public Integer getTruckTypePairingId() {
        return truckTypePairingId;
    }

    public Integer getTruckId() {
        return truckId;
    }

    public Integer getTireModelId() {
        return tireModelId;
    }

    public Integer getTirePositionIndex() {
        return tirePositionIndex;
    }

    public Integer getTruckMileageAtInstall() {
        return truckMileageAtInstall;
    }
}
