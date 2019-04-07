package app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="tire_purchase")
public class TirePurchase {
    @Id
    @Column(name="Tire_Purchase_ID")
    private Integer tirePurchaseId;
    @Column(name="Tire_Model_ID")
    private Integer tireModelId;
    @Column(name="Tire_Vendor_ID")
    private Integer tireVendorId;
    @Column(name="Tire_Purchase_Quantity")
    private Integer tirePurchaseQuantity;
    @Column(name="Tire_Purchase_Price_Per_Unit")
    private Double tirePurchasePricePerUnit;
    @Column(name="Tire_Purchase_Date")
    private Date tirePurchaseDate;
}
