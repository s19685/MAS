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
                     Double price, Building building, List<Furniture> furnitures, Integer parkingNumber) {
        super(flatNumber, entrycode, details, roomsNumber, area, price, building, furnitures);
        this.parkingNumber = parkingNumber;
    }

    public Integer getParkingNumber() {
        return parkingNumber;
    }

    public void setParkingNumber(Integer parkingNumber) {
        this.parkingNumber = parkingNumber;
    }
}
