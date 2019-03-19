package app.service.implementation;

import app.domain.Employee;
import app.repository.EmployeeRepository;
import app.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadServiceImpl implements ReadService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public ReadServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Iterable<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
}
