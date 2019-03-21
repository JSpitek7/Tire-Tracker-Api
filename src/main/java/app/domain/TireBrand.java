package app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tire_Brand")
public class TireBrand {
    @Id
    @Column(name="Tire_Brand_ID")
    private Integer tireBrandId;
    @Column(name="Tire_Brand_Name")
    private String tireBrandName;

    public Integer getTireBrandId() {return this.tireBrandId;}
    public String getTireBrandName() {return this.tireBrandName;}

}
