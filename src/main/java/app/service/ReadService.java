package app.service;

import app.domain.TireVendor;
import app.models.EmployeeDto;
import app.models.TireDto;
import app.models.TruckDto;


public interface ReadService {
    EmployeeDto login(String username, String password);
    Iterable<TireDto> getAllTires();
    Iterable<TruckDto> getAllTrucks();
    Iterable<TireDto> getAllTiresInStock();
    Iterable<TireVendor> getAllVendors();
}
