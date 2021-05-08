package Multiaspect;

public class Apartment extends Flat{

    private int parkingNumber;
    private boolean hasBalcony;

    public Apartment(int flatNumber, double area, String details, boolean isMultiFloored, int parkingNumber, boolean hasBalcony) {
        super(flatNumber, area, details, isMultiFloored);
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
