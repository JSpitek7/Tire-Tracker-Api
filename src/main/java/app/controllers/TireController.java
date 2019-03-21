package app.controllers;
import app.domain.*;
import app.models.EmployeeDto;
import app.models.TireChangeDto;
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

    @GetMapping("tire/vendors")
    public @ResponseBody Iterable<TireVendor> getTireVendors() {
        return readService.findAllTireVendors();
    }

    @GetMapping("tire/brands")
    public @ResponseBody Iterable<TireBrand> getTireBrands() {
        return readService.findAllTireBrands();
    }

    @GetMapping("tire/brands/{brandId}/models")
    public @ResponseBody Iterable<TireModel> getTireModels(@PathVariable Integer brandId) {
        return readService.findTireModelsByBrandId(brandId);
    }

    @PostMapping("tire/changeTire")
    public @ResponseBody String addTireChange(@RequestHeader(value="Content-Type") String contentType,
                                              @RequestBody TireChangeDto tireChangeDto) {
        System.out.println("The process has begun");
        return writeService.changeTire(tireChangeDto);
    }
}
