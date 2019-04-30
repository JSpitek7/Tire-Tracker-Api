package app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tire_Status")
public class TireStatus {
    @Id
    @Column(name="Tire_Status_ID")
    private Integer tireStatusId;
    @Column(name="Tire_Status_Description")
    private String tireStatusDescription;

    public Integer getTireStatusId() {
        return tireStatusId;
    }

    public String getTireStatusDescription() {
        return tireStatusDescription;
    }
}
