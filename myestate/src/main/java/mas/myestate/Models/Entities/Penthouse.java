package mas.myestate.Models.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = Penthouse.DISCRIMINATOR)
@DiscriminatorValue(value = Penthouse.DISCRIMINATOR)
public class Penthouse extends Flat {

    public static final String DISCRIMINATOR = "PENTHOUSE";

    @Column(nullable = false)
    private boolean isWithPool;

    private Penthouse() {
    }

    private Penthouse(int flatNumber, String entrycode, String details, Integer roomsNumber, Double area,
                     Double price, Building building, boolean isWithPool) {
        super(flatNumber, entrycode, details, roomsNumber, area, price, building);
        this.isWithPool = isWithPool;
    }

    public static Flat createPenthouse(int flatNumber, String entrycode, String details, Integer roomsNumber,
                                    Double area, Double price, Building building, boolean isWithPool) throws Exception {
        if (building == null) throw new Exception("Building does not exists");
        Flat flat = new Penthouse(flatNumber, entrycode, details, roomsNumber, area, price, building,isWithPool);
        building.addFlat(flat);
        return flat;
    }

    public boolean isWithPool() {
        return isWithPool;
    }

    public void setWithPool(boolean withPool) {
        isWithPool = withPool;
    }
}
