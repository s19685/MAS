package kwalifikowana;

public class Apartment {

    private Integer flatNumber;
    private double area;
    private String details;

    private Building building;

    public Apartment(Integer flatNumber, double area, String details) {
        this.flatNumber = flatNumber;
        this.area = area;
        this.details = details;
    }

    public void addBuilding(Building building) throws Exception {
        if (this.building != null) throw new Exception("Apartment in building already");
        this.building = building;
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


}
