package mas.mpp5.Inheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "VILLA")
@DiscriminatorValue(value = Villa.DISCRIMINATOR)
public class Villa extends Flat {

    public static final String DISCRIMINATOR = "VILLA";

    @Column(nullable = false)
    private int parkingSlots;

    @Column(nullable = true)
    private boolean hasPool;

    public Villa() {
    }

    public Villa(int flatNumber, double area, String name, int parkingSlots, boolean hasPool) {
        super(flatNumber, area, name);
        this.parkingSlots = parkingSlots;
        this.hasPool = hasPool;
    }

    public int getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(int parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public boolean isHasPool() {
        return hasPool;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }
}
