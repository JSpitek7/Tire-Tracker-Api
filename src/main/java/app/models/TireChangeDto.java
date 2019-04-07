package app.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class TireChangeDto {
    private Integer driverId;
    private Integer mileage;
    private Integer tireIndex;
    private Integer modelId;
    private String licensePlate;

    public Integer getDriverId() {
        return driverId;
    }

    public Integer getMileage() {
        return mileage;
    }

    public Integer getTireIndex() {
        return tireIndex;
    }

    public Integer getModelId() {
        return modelId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public boolean validate() {
        if (this.driverId == null) return false;
        if (this.mileage == null) return false;
        if (this.tireIndex == null) return false;
        if (this.modelId == null) return false;
        if (this.licensePlate == null) return false;
        else return true;
    }
}
