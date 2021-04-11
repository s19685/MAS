import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Flat implements Serializable {

    private static final double STANDARD_PRICE = 1000;
    private static List<Flat> extent = new ArrayList<>();

    private int flatNumber;
    private int entryCode;
    private double area;
    private String details;
    private List<String> furnitures;

    public Flat(int flatNumber, int entryCode, double area, String details, List<String> furnitures) {
        this.flatNumber = flatNumber;
        this.entryCode = entryCode;
        this.area = area;
        this.details = details;
        this.furnitures = furnitures;
        extent.add(this);
    }

    public static List<Flat> getListOfFlats() {
        return extent;
    }

    public static void showExtent() {
        for (Flat f : extent) System.out.println(f);
    }

    public Double getPrice() {
        return area * STANDARD_PRICE;
    }

    public static void writeExtent(ObjectOutputStream stream){
        try {
            stream.writeObject(extent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readExtent(ObjectInputStream stream) {
        try {
            extent = (List<Flat>) stream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public int getEntryCode() {
        return entryCode;
    }

    public void setEntryCode(int entryCode) {
        this.entryCode = entryCode;
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

    public List<String> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(List<String> furnitures) {
        this.furnitures = furnitures;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " {" +
                "price=" + this.getPrice() +
                ", flatNumber=" + flatNumber +
                ", entryCode=" + entryCode +
                ", area=" + area +
                ", details='" + details + '\'' +
                ", furnitures=" + furnitures +
                '}';
    }
}
