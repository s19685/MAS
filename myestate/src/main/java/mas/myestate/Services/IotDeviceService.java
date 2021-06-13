package mas.myestate.Services;

import mas.myestate.Models.DTOs.IotDeviceDTO;
import mas.myestate.Models.Entities.IotDevice;
import mas.myestate.Models.Repositories.IotDeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IotDeviceService {

    private IotDeviceRepo repo;

    @Autowired
    public IotDeviceService(IotDeviceRepo repo) {
        this.repo = repo;
    }

    public List<IotDeviceDTO> getAllDevices() {
        List<IotDeviceDTO> res = new ArrayList<>();

        for (IotDevice d : repo.findAll()) {
            res.add(new IotDeviceDTO(d.getId(), d.getName(), d.getPrice()));
        }

        return res;
    }
}
