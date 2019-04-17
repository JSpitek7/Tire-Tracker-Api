package app.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class TruckDto {
    private Integer truckId;
    private String truckLicensePlate;

    public TruckDto(Integer truckId, String truckLicensePlate) {
        this.truckId = truckId;
        this.truckLicensePlate = truckLicensePlate;
    }

    public Integer getTruckId() {
        return truckId;
    }

    public String getTruckLicensePlate() {
        return truckLicensePlate;
    }
}
