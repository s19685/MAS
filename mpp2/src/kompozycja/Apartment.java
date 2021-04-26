package kompozycja;

import kompozycja.Building;

public class Apartment {

    private Integer flatNumber;
    private double area;
    private String details;
    private boolean deleted;

    private Building building;

    private Apartment(Integer flatNumber, double area, String details, Building building) {
        this.flatNumber = flatNumber;
        this.area = area;
        this.details = details;
        this.building = building;
        deleted = false;
    }

    public static Apartment createApartment(Integer flatNumber, double area, String details, Building building) throws Exception {
        if(building == null) throw new Exception("Apartment cant exist without building");

        Apartment apartment = new Apartment(flatNumber, area, details, building);
        building.addApartment(apartment);

        return apartment;
    }

    public Integer getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(Integer flatNumber) {
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
