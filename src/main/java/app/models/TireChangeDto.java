package app.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class TireChangeDto {
    private Integer driverId;
    private Integer mileage;
    private Integer tireIndex;
    private Integer brandId;
    private Integer modelId;
    private String vin;

    public Integer getDriverId() {
        return driverId;
    }

    public Integer getMileage() {
        return mileage;
    }

    public Integer getTireIndex() {
        return tireIndex;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public String getVin() {
        return vin;
    }
}
