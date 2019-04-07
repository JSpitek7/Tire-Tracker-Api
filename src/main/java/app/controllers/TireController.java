package app.controllers;
import app.models.*;
import app.service.ReadService;
import app.service.WriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping("/trucks")
    public @ResponseBody Iterable<TruckDto> getTrucks() {
        return readService.getAllTrucks();
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
}
