package app.service;

import app.models.EmployeeDto;
import app.models.TireDto;
import app.models.TruckDto;


public interface ReadService {
    EmployeeDto login(String username, String password);
    Iterable<TireDto> getAllTires();
    Iterable<TruckDto> getAllTrucks();
}
