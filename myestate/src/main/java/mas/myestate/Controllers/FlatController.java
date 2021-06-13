package mas.myestate.Controllers;

import mas.myestate.Models.DTOs.FlatDTO;
import mas.myestate.Models.DTOs.FlatsDTO;
import mas.myestate.Models.DTOs.PickedDevicesDTO;
import mas.myestate.Models.Entities.Flat;
import mas.myestate.Services.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/flat")
public class FlatController {

    private FlatService service;

    @Autowired
    public FlatController(FlatService service) {
        this.service = service;
    }

    @GetMapping()
    public List<FlatsDTO> getAllFlats() {
        return service.getAllFlats();
    }

    @GetMapping("/{id}")
    public FlatDTO get(@PathVariable Long id) {
        return service.getFlatById(id);
    }

    @PutMapping("/{id}")
    public void editFlat(@PathVariable Long id, @RequestBody PickedDevicesDTO devices) {
        service.addDevicesToFlat(id,devices);
    }

}
