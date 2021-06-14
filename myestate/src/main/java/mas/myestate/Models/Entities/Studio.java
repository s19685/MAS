package mas.myestate.Models.Entities;

import javax.persistence.*;

@Entity
@Table(name = Studio.DISCRIMINATOR)
@DiscriminatorValue(value = Studio.DISCRIMINATOR)
public class Studio extends Flat {

    public static final String DISCRIMINATOR = "STUDIO";

    private Studio() {
    }

    private Studio(int flatNumber, String entrycode, String details, Integer roomsNumber,
                   Double area, Double price, Building building) {
        super(flatNumber, entrycode, details, roomsNumber, area, price, building);
    }

    public static Flat createStudio(int flatNumber, String entrycode, String details, Integer roomsNumber,
                                    Double area, Double price, Building building) throws Exception {
        if (building == null) throw new Exception("Building does not exists");
        Flat flat = new Studio(flatNumber, entrycode, details, roomsNumber, area, price, building);
        building.addFlat(flat);
        return flat;
    }


}
