package z_atrybutem;

import java.util.ArrayList;
import java.util.List;

public class Apartment {

    private int flatNumber;
    private double area;
    private String details;

    private List<TenatInApartment> tenatInApartments;

    public Apartment(int flatNumber, double area, String details) {
        this.flatNumber = flatNumber;
        this.area = area;
        this.details = details;
        tenatInApartments = new ArrayList<>();
    }

    public void addTenatInApartment(TenatInApartment item){
        tenatInApartments.add(item);
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<TenatInApartment> getTenatInApartments() {
        return tenatInApartments;
    }

    public void setTenatInApartments(List<TenatInApartment> tenatInApartments) {
        this.tenatInApartments = tenatInApartments;
    }
}
