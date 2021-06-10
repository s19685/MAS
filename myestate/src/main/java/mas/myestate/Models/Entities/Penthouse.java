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

    public Penthouse() {
    }

    public Penthouse(int flatNumber, String entrycode, String details, Integer roomsNumber, Double area,
                     Double price, Building building, List<Furniture> furnitures, boolean isWithPool) {
        super(flatNumber, entrycode, details, roomsNumber, area, price, building, furnitures);
        this.isWithPool = isWithPool;
    }

    public boolean isWithPool() {
        return isWithPool;
    }

    public void setWithPool(boolean withPool) {
        isWithPool = withPool;
    }
}
