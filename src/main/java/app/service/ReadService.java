package app.service;

import app.domain.Employee;

public interface ReadService {
    Iterable<Employee> findAllEmployees();
}
