package mas.myestate.Models.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = Studio.DISCRIMINATOR)
@DiscriminatorValue(value = Studio.DISCRIMINATOR)
public class Studio extends Flat {

    public static final String DISCRIMINATOR = "STUDIO";

    public Studio() {
    }

    public Studio(int flatNumber, String entrycode, String details, Integer roomsNumber,
                  Double area, Double price, Building building, List<Furniture> furnitures) {
        super(flatNumber, entrycode, details, roomsNumber, area, price, building, furnitures);
    }

    public Studio(int flatNumber, String entrycode, String details, Integer roomsNumber,
                  Double area, Double price) {
        super(flatNumber, entrycode, details, roomsNumber, area, price);
    }

}
