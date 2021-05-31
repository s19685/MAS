package mas.mpp5.Inheritance;

import javax.persistence.*;

@Entity
@Table(name = "STUDIO")
@DiscriminatorValue(value = Studio.DISCRIMINATOR)
public class Studio extends Flat {

    public static final String DISCRIMINATOR = "STUDIO";

    @Column(nullable = false)
    private int parkingNumber;

    @Column(nullable = false)
    private boolean hasBalcony;

    public Studio(){
    }

    public Studio(int flatNumber, double area, String name, int parkingNumber, boolean hasBalcony) {
        super(flatNumber, area, name);
        this.parkingNumber = parkingNumber;
        this.hasBalcony = hasBalcony;
    }

    public int getParkingNumber() {
        return parkingNumber;
    }

    public void setParkingNumber(int parkingNumber) {
        this.parkingNumber = parkingNumber;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }


}
