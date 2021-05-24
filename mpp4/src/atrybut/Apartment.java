package atrybut;

public class Apartment {

    private static final double MINIMAL_APARTMENT_AREA = 100.0;

    private int flatNumber;
    private int parkingNumber;
    private double area;


    public Apartment(int flatNumber, int parkingNumber, double area) throws Exception {
        this.flatNumber = flatNumber;
        this.parkingNumber = parkingNumber;
        setArea(area);
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public int getParkingNumber() {
        return parkingNumber;
    }

    public void setParkingNumber(int parkingNumber) {
        this.parkingNumber = parkingNumber;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) throws Exception {
        if(area < MINIMAL_APARTMENT_AREA) {
            throw new Exception("Too small area for apartment. minimal value: "+MINIMAL_APARTMENT_AREA);
        }

        this.area = area;
    }
}
