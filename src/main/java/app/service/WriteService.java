package app.service;

import app.models.AddTruckDto;
import app.models.PurchaseTireDto;
import app.models.TireChangeDto;

public interface WriteService {
    String changeTire(TireChangeDto tireChangeDto);
    String addTruck(AddTruckDto addTruckDto);
    String purchaseTire(PurchaseTireDto purchaseTireDto);
}
