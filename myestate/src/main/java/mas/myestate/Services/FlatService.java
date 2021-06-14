package mas.myestate.Services;

import mas.myestate.Models.DTOs.FlatDTO;
import mas.myestate.Models.DTOs.FlatsDTO;
import mas.myestate.Models.DTOs.FurnitureDTO;
import mas.myestate.Models.DTOs.PickedDevicesDTO;
import mas.myestate.Models.Entities.Flat;
import mas.myestate.Models.Entities.Furniture;
import mas.myestate.Models.Entities.IotDevice;
import mas.myestate.Models.Repositories.FlatRepo;
import mas.myestate.Models.Repositories.IotDeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlatService {

    private FlatRepo flatRepo;
    private IotDeviceRepo deviceRepo;

    @Autowired
    public FlatService(FlatRepo flatRepo, IotDeviceRepo deviceRepo) {
        this.flatRepo = flatRepo;
        this.deviceRepo = deviceRepo;
    }

    public List<FlatsDTO> getAllFlats() {
        List<Flat> flats = flatRepo.findAll();
        List<FlatsDTO> res = new ArrayList<>();

        for (Flat f : flats) {
            res.add(new FlatsDTO(f.getId(), f.getName(), f.getDetails(), f.getPrice()));
        }

        return res;
    }

    public FlatDTO getFlatById(Long id) {
        Flat f = flatRepo.findById(id).orElseThrow();
        List<Furniture> furnitures = f.getFurnitures();
        List<FurnitureDTO> fur = new ArrayList<>();

        for (Furniture fu : furnitures) {
            fur.add(new FurnitureDTO(fu.getName(),fu.getHeight(),fu.getWidth(),fu.getLength()));
        }

        return new FlatDTO(f.getId(), f.getName(), f.getArea(), f.getPrice(), f.getDetails(),f.getEntrycode(), fur);
    }

    public void addDevicesToFlat(Long id, PickedDevicesDTO devices) {
        Flat flat = flatRepo.findById(id).orElseThrow();
        List<IotDevice> devicesList = new ArrayList<>();

        System.out.println(devices.getFirst());
        System.out.println(devices.getSecond());
        System.out.println(devices.getThird());

        if(devices.getFirst()) devicesList.add(deviceRepo.findById(1L).orElseThrow());
        if(devices.getSecond()) devicesList.add(deviceRepo.findById(2L).orElseThrow());
        if(devices.getThird()) devicesList.add(deviceRepo.findById(3L).orElseThrow());

        flat.setDevices(devicesList);

        flatRepo.save(flat);
    }
}
