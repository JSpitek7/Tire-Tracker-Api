package app.controllers;
import app.domain.Employee;
import app.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TireController{

    private ReadService readService;

    @Autowired
    public TireController(
            ReadService readService
    ) {
        this.readService = readService;
    }

    @RequestMapping("/employees")
    public @ResponseBody Iterable<Employee> getEmployees() {
        return readService.findAllEmployees();}
}
