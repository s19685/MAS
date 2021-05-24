package unique;

import java.util.ArrayList;
import java.util.List;

public class Apartment {

    private static List<Integer> allFlatNumbers = new ArrayList<>();

    private Integer flatNumber;
    private int parkingNumber;
    private double area;


    public Apartment(Integer flatNumber, int parkingNumber, double area) throws Exception {
        setFlatNumber(flatNumber);
        this.parkingNumber = parkingNumber;
        this.area = area;
    }

    public Integer getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(Integer flatNumber) throws Exception {
        if(allFlatNumbers.contains(flatNumber)) throw new Exception("Mieszkanie o takim numerze istnieje");

        allFlatNumbers.add(flatNumber);
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

    public void setArea(double area){
        this.area = area;
    }
}