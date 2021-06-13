package mas.myestate.Controllers;

import mas.myestate.Models.DTOs.IotDeviceDTO;
import mas.myestate.Models.Entities.IotDevice;
import mas.myestate.Services.IotDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/devices")
public class IotDeviceController {

    private IotDeviceService service;

    @Autowired
    public IotDeviceController(IotDeviceService service) {
        this.service = service;
    }

    @GetMapping()
    public List<IotDeviceDTO> getAllDevices(){
        return service.getAllDevices();
    }

}
