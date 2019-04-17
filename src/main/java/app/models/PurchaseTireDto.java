package app.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class PurchaseTireDto {
    private Integer tireModelId;
    private Integer tirePurchaseQuantity;
    private Double tirePurchasePricePerUnit;
    private Integer tireVendorId;

    public Integer getTireModelId() {return tireModelId;}
    public Integer getTirePurchaseQuantity() {return tirePurchaseQuantity;}
    public Double getTirePurchasePricePerUnit() {return tirePurchasePricePerUnit;}
    public Integer getTireVendorId() {return tireVendorId;}

    public boolean validate() {
        if (this.tireModelId == null) return false;
        if (this.tirePurchaseQuantity == null) return false;
        if (this.tirePurchasePricePerUnit == null) return false;
        if (this.tireVendorId == null) return false;
        else return true;
    }
}
