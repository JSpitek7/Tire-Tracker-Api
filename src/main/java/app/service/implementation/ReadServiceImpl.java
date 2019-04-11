package app.service.implementation;

import app.domain.*;
import app.models.EmployeeDto;
import app.models.TireDto;
import app.models.TruckDto;
import app.repository.*;
import app.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    private TireRepository tireRepository;

    @Autowired
    public ReadServiceImpl(EmployeeRepository employeeRepository,
                           EmployeeTypeRepository employeeTypeRepository,
                           TireBrandRepository tireBrandRepository,
                           TireModelRepository tireModelRepository,
                           TireVendorRepository tireVendorRepository,
                           TruckRepository truckRepository,
                           TruckBrandRepository truckBrandRepository,
                           TruckModelRepository truckModelRepository,
                           TruckTirePairingRepository truckTirePairingRepository,
                           TireRepository tireRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeTypeRepository = employeeTypeRepository;
        this.tireBrandRepository = tireBrandRepository;
        this.tireModelRepository = tireModelRepository;
        this.tireVendorRepository = tireVendorRepository;
        this.truckRepository = truckRepository;
        this.truckBrandRepository = truckBrandRepository;
        this.truckModelRepository = truckModelRepository;
        this.truckTirePairingRepository = truckTirePairingRepository;
        this.tireRepository = tireRepository;
    }

    public EmployeeDto login(String username, String password) {
        Optional<Employee> employeeRecord = employeeRepository.findByEmpUsernameAndEmpPassword(username, password);
        if (employeeRecord.isPresent()) {
            Employee employee = employeeRecord.get();
            Optional<EmployeeType> empTypeRecord = employeeTypeRepository.findByEmpTypeId(employee.getEmpTypeId());
            EmployeeType empType = empTypeRecord.get();
            String name = employee.getEmpFName() + " " + employee.getEmpLName();
            EmployeeDto employeeDto = new EmployeeDto(employee.getEmpId(), name, employee.getEmpPhoneNum(),
                    employee.getEmpEmail(), empType.getEmpTypeTitle());
            return employeeDto;
        } else return new EmployeeDto(false);
    }

    public Iterable<TireDto> getAllTires() {
        ArrayList<TireDto> tireDtos = new ArrayList<>();
        tireModelRepository.findAll().forEach(tire -> {
            tireDtos.add(new TireDto(
                    tire.getTireModelId(),
                    String.format("%s %s",
                            tireBrandRepository.findById(tire.getTireBrandId()).get().getTireBrandName(),
                            tire.getTireModelName())
            ));
        });
        return tireDtos;

    }

    public Iterable<TireDto> getAllTiresInStock() {
        ArrayList<TireDto> tireDtos = new ArrayList<>();
        tireRepository.findInStockTireModelIds().forEach(modelId -> {
            TireModel tireModel = tireModelRepository.findById(modelId).get();
            tireDtos.add(new TireDto(
                    modelId,
                    String.format("%s %s",
                            tireBrandRepository.findById(tireModel.getTireBrandId()).get().getTireBrandName(),
                            tireModel.getTireModelName())
            ));
        });
        return tireDtos;
    }

    public Iterable<TruckDto> getAllTrucks() {
        ArrayList<TruckDto> truckDtos = new ArrayList<>();
        truckModelRepository.findAll().forEach(truck -> {
            truckDtos.add(new TruckDto(
                    truck.getTruckModelId(),
                    String.format("%s %s",
                            truckBrandRepository.findById(truck.getTruckBrandId()).get().getTruckBrandName(),
                            truck.getTruckModelName())
            ));
        });
        return truckDtos;
    }

    public Iterable<TireVendor> getAllVendors() {
        return tireVendorRepository.findAll();
    }
}
