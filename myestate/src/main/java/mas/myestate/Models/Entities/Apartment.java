package mas.myestate.Models.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = Apartment.DISCRIMINATOR)
@DiscriminatorValue(value = Apartment.DISCRIMINATOR)
public class Apartment extends Flat {


    public static final String DISCRIMINATOR = "APARTMENT";

    @Column(nullable = false)
    private Integer parkingNumber;


    public Apartment() {
    }

    public Apartment(int flatNumber, String entrycode, String details, Integer roomsNumber, Double area,
                     Double price, Building building, Integer parkingNumber) {
        super(flatNumber, entrycode, details, roomsNumber, area, price, building);
        this.parkingNumber = parkingNumber;
    }

    public static Flat createApartment(int flatNumber, String entrycode, String details, Integer roomsNumber,
                                       Double area, Double price, Building building, Integer parkingNumber) throws Exception {
        if (building == null) throw new Exception("Building does not exists");
        Flat flat = new Apartment(flatNumber, entrycode, details, roomsNumber, area, price, building,parkingNumber);
        building.addFlat(flat);
        return flat;
    }

    public Integer getParkingNumber() {
        return parkingNumber;
    }

    public void setParkingNumber(Integer parkingNumber) {
        this.parkingNumber = parkingNumber;
    }
}
