package wlasne;

import xor.Person;

public class Apartment {
    private Integer flatNumber;
    private int parkingNumber;
    private double area;

    private Supervisor supervisor;


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

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

}
