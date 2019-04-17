package app.service;

import app.domain.TireVendor;
import app.models.EmployeeDto;
import app.models.TireDto;
import app.models.TruckDto;
import app.models.TruckTypeDto;


public interface ReadService {
    EmployeeDto login(String username, String password);
    Iterable<TireDto> getAllTires();
    Iterable<TruckTypeDto> getAllTrucks();
    Iterable<TireDto> getAllTiresInStock();
    Iterable<TireVendor> getAllVendors();
    Iterable<TruckDto> getTrucksByEmpId(Integer empId);
}
