package zwykla;

import java.util.ArrayList;
import java.util.List;

public class Flat {

    private int flatNumber;
    private double area;
    private String details;

    private List<Furniture> furnitures;

    public Flat(int flatNumber, double area, String details) {
        this.flatNumber = flatNumber;
        this.area = area;
        this.details = details;
        furnitures = new ArrayList<>();
    }

    public Flat(int flatNumber, double area, String details, List<Furniture> furnitures) {
        this.flatNumber = flatNumber;
        this.area = area;
        this.details = details;
        this.furnitures = new ArrayList<>();
        for (Furniture f : furnitures) addFurniture(f);

    }

    public void addFurniture(Furniture furniture){
        furnitures.add(furniture);
        furniture.setFlat(this);
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

    public List<Furniture> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(List<Furniture> furnitures) {
        this.furnitures = furnitures;
    }
}
