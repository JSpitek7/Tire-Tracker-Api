package app.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="tire_purchase")
public class TirePurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Tire_Purchase_ID")
    private Integer tirePurchaseId;
    @Column(name="Tire_Vendor_ID")
    private Integer tireVendorId;
    @Column(name="Tire_Purchase_Quantity")
    private Integer tirePurchaseQuantity;
    @Column(name="Tire_Purchase_Price_Per_Unit")
    private Double tirePurchasePricePerUnit;
    @Column(name="Tire_Purchase_Date")
    private LocalDateTime tirePurchaseDate;

    public Integer getTirePurchaseId() {
        return this.tirePurchaseId;
    }

    public TirePurchase(Integer tireVendorId, Integer tirePurchaseQuantity, Double tirePurchasePricePerUnit) {
        this.tireVendorId = tireVendorId;
        this.tirePurchaseQuantity = tirePurchaseQuantity;
        this.tirePurchasePricePerUnit = tirePurchasePricePerUnit;
        this.tirePurchaseDate = LocalDateTime.now();
    }
}
