package mas.myestate.Services;

import mas.myestate.Models.DTOs.RentalDTO;
import mas.myestate.Models.Entities.Flat;
import mas.myestate.Models.Entities.Rental;
import mas.myestate.Models.Entities.Resident;
import mas.myestate.Models.Repositories.FlatRepo;
import mas.myestate.Models.Repositories.RentRepo;
import mas.myestate.Models.Repositories.ResidentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalService {

    private RentRepo rentRepo;
    private ResidentRepo residentRepo;
    private FlatRepo flatRepo;

    @Autowired
    public RentalService(RentRepo rentRepo, ResidentRepo residentRepo, FlatRepo flatRepo) {
        this.rentRepo = rentRepo;
        this.residentRepo = residentRepo;
        this.flatRepo = flatRepo;
    }

    public Long createNewRent(RentalDTO r) {
        System.out.println(r.toString());
//        Resident resident = residentRepo.findById(r.getResidentId()).orElseThrow();

        Resident resident = new Resident(r.getFirstName(), r.getLastName());
        Flat flat = flatRepo.findById(r.getFlatId()).orElseThrow();

        Rental res = new Rental(r.getDateFrom(), r.getDateTo(), flat, resident);

        residentRepo.save(resident);
        Rental dto = rentRepo.save(res);

        return dto.getId();

    }

    public String getCost(Long id) {
        Rental rental = rentRepo.findById(id).orElseThrow();


        return rental.getCost() + " zl";
    }
}
