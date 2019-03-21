package app.service;

import app.domain.*;
import app.models.EmployeeDto;

public interface ReadService {
    Iterable<Employee> findAllEmployees();
    Iterable<EmployeeType> findAllEmployeeTypes();
    Iterable<TireBrand> findAllTireBrands();
    Iterable<TireModel> findAllTireModels();
    Iterable<TireVendor> findAllTireVendors();
    Iterable<Truck> findAllTrucks();
    Iterable<TruckBrand> findAllTruckBrands();
    Iterable<TruckModel> findAllTruckModels();
    Iterable<TruckTirePairing> findAllTruckTirePairings();

    EmployeeDto login(String username, String password);
    Iterable<TireModel> findTireModelsByBrandId(Integer brandId);
}
