package app.controllers;
import app.domain.TireVendor;
import app.models.*;
import app.service.ReadService;
import app.service.WriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://tire-tracker-app.herokuapp.com")
@RestController
@RequestMapping("/")
public class TireController{

    private ReadService readService;
    private WriteService writeService;

    @Autowired
    public TireController(
            ReadService readService,
            WriteService writeService
    ) {
        this.readService = readService;
        this.writeService = writeService;
    }

    @GetMapping("/login/{username}/{password}")
    public @ResponseBody EmployeeDto login(@PathVariable String username, @PathVariable String password) {
        return readService.login(username,password);
    }

    @GetMapping("/tires")
    public @ResponseBody Iterable<TireDto> getTires() {
        return readService.getAllTires();
    }

    @GetMapping("/tires/inStock")
    public @ResponseBody Iterable<TireDto> getTiresInStock() {return readService.getAllTiresInStock();}

    @PostMapping("tires/changeTire")
    public @ResponseBody String addTireChange(@RequestHeader(value="Content-Type") String contentType,
                                              @RequestBody TireChangeDto tireChangeDto) {
        if (tireChangeDto.validate()) {
            String response = writeService.changeTire(tireChangeDto);
            System.out.println("The status of the write attempt is: " + response);
            return response;
        } else {
            System.out.println("One or more fields are null");
            return "One or more fields are null.";
        }
    }

    @PostMapping("tires/purchaseTires")
    public @ResponseBody String purchaseTires(@RequestHeader(value="Content-Type") String contentType,
                                              @RequestBody PurchaseTireDto purchaseTireDto) {
        if (purchaseTireDto.validate()) {
            return writeService.purchaseTire(purchaseTireDto);
        } else {
            return "Failure: One or more fields are null.";
        }
    }

    @GetMapping("/trucks")
    public @ResponseBody Iterable<TruckTypeDto> getTrucks() {
        return readService.getAllTrucks();
    }

    @GetMapping("/trucks/tracked/{empId}")
    public @ResponseBody Iterable<TruckDto> getEmployeeTrucks(@PathVariable Integer empId) {
        return readService.getTrucksByEmpId(empId);
    }

    @PostMapping("trucks/add")
    public @ResponseBody String addTruck(@RequestHeader(value="Content-Type") String contentType,
                                         @RequestBody AddTruckDto addTruckDto) {
        if (addTruckDto.validate()) {
            String response = writeService.addTruck(addTruckDto);
            System.out.println("The status of the write attempt is: " + response);
            return response;
        } else {
            System.out.println("One or more fields are null");
            return ("One or more fields are null");
        }
    }

    @GetMapping("/vendors")
    public @ResponseBody Iterable<TireVendor> getVendors() { return readService.getAllVendors();}
}
