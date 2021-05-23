package ordered;

public class Apartment implements Comparable<Apartment>{

    private Integer flatNumber;
    private int parkingNumber;
    private double area;


    public Apartment(Integer flatNumber, int parkingNumber, double area) {
        this.flatNumber = flatNumber;
        this.parkingNumber = parkingNumber;
        this.area = area;
    }

    public Integer getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(Integer flatNumber) {
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
        this.area = area;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "flatNumber=" + flatNumber +
                ", parkingNumber=" + parkingNumber +
                ", area=" + area +
                '}';
    }

    @Override
    public int compareTo(Apartment a) {
        if(getFlatNumber() ==null || a.getFlatNumber() == null ) return 0;

        return getFlatNumber().compareTo(a.getFlatNumber());

    }
}