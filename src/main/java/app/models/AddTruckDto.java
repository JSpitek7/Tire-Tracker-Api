package app.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize
public class AddTruckDto {
    private Integer empId;
    private String truckLicensePlate;
    private Integer truckModelId;
    private List<TruckTireDto> truckTireDtoList;

    public Integer getEmpId() {
        return empId;
    }

    public String getTruckLicensePlate() {
        return truckLicensePlate;
    }

    public Integer getTruckModelId() {
        return truckModelId;
    }

    public List<TruckTireDto> getTruckTireDtoList() {
        return truckTireDtoList;
    }

    public boolean validate() {
        if (empId == null) return false;
        if (truckLicensePlate == null) return false;
        if (truckModelId == null) return false;
        else return true;
    }
}
