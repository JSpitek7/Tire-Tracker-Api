package app.service.implementation;

import app.domain.*;
import app.models.EmployeeDto;
import app.repository.*;
import app.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReadServiceImpl implements ReadService {

    private EmployeeRepository employeeRepository;
    private EmployeeTypeRepository employeeTypeRepository;
    private TireBrandRepository tireBrandRepository;
    private TireModelRepository tireModelRepository;
    private TireVendorRepository tireVendorRepository;
    private TruckRepository truckRepository;
    private TruckBrandRepository truckBrandRepository;
    private TruckModelRepository truckModelRepository;
    private TruckTirePairingRepository truckTirePairingRepository;

    @Autowired
    public ReadServiceImpl(EmployeeRepository employeeRepository,
                           EmployeeTypeRepository employeeTypeRepository,
                           TireBrandRepository tireBrandRepository,
                           TireModelRepository tireModelRepository,
                           TireVendorRepository tireVendorRepository,
                           TruckRepository truckRepository,
                           TruckBrandRepository truckBrandRepository,
                           TruckModelRepository truckModelRepository,
                           TruckTirePairingRepository truckTirePairingRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeTypeRepository = employeeTypeRepository;
        this.tireBrandRepository = tireBrandRepository;
        this.tireModelRepository = tireModelRepository;
        this.tireVendorRepository = tireVendorRepository;
        this.truckRepository = truckRepository;
        this.truckBrandRepository = truckBrandRepository;
        this.truckModelRepository = truckModelRepository;
        this.truckTirePairingRepository = truckTirePairingRepository;
    }

    public Iterable<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Iterable<EmployeeType> findAllEmployeeTypes() {
        return employeeTypeRepository.findAll();
    }

    public Iterable<TireBrand> findAllTireBrands() {return tireBrandRepository.findAll();}
    public Iterable<TireModel> findAllTireModels() {return tireModelRepository.findAll();}
    public Iterable<TireVendor> findAllTireVendors() {return tireVendorRepository.findAll();}
    public Iterable<Truck> findAllTrucks() {return truckRepository.findAll();}
    public Iterable<TruckBrand> findAllTruckBrands() {return truckBrandRepository.findAll();}
    public Iterable<TruckModel> findAllTruckModels() {return truckModelRepository.findAll();}
    public Iterable<TruckTirePairing> findAllTruckTirePairings() {return truckTirePairingRepository.findAll();}

    public EmployeeDto login(String username, String password) {
        Optional<Employee> employeeRecord = employeeRepository.findByEmpUsernameAndEmpPassword(username, password);
        Employee employee = employeeRecord.get();
        Optional<EmployeeType> empTypeRecord =  employeeTypeRepository.findByEmpTypeId(employee.getEmpTypeId());
        EmployeeType empType = empTypeRecord.get();
        String name = employee.getEmpFName() + " " + employee.getEmpLName();
        EmployeeDto employeeDto = new EmployeeDto(employee.getEmpId(),name,employee.getEmpPhoneNum(),
                employee.getEmpEmail(), empType.getEmpTypeTitle());
        return employeeDto;
    }

    public Iterable<TireModel> findTireModelsByBrandId(Integer brandId) {
        return tireModelRepository.findAllByTireBrandId(brandId);
    }
}
