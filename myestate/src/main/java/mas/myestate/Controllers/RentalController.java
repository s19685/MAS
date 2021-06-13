package mas.myestate.Controllers;

import mas.myestate.Models.DTOs.RentalDTO;
import mas.myestate.Models.Entities.Rental;
import mas.myestate.Services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/rental")
public class RentalController {

    private RentalService service;

    @Autowired
    public RentalController(RentalService service) {
        this.service = service;
    }

    @PostMapping()
    public void createRent(@RequestBody RentalDTO rental) {
        service.createNewRent(rental);
    }


}
