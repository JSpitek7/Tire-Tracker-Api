package app.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class TireChangeDto {
    private Integer truckId;
    private Integer mileage;
    private Integer tireIndex;
    private Integer modelId;

    public Integer getTruckId() {
        return truckId;
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

    public boolean validate() {
        if (this.truckId == null) return false;
        if (this.mileage == null) return false;
        if (this.tireIndex == null) return false;
        if (this.modelId == null) return false;
        else return true;
    }
}
