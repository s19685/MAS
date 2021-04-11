import java.util.List;

public class Apartment extends Flat {

    private static int PRICE_PER_SQUAREMETER = 2000;
    private static int MAX_NUMBER_OF_TENATS = 6;

    private Integer parkingNumber;

    public Apartment(int flatNumber, int entryCode, double area, String details, List<String> furnitures) {
        super(flatNumber, entryCode, area, details, furnitures);
    }

    public Apartment(int flatNumber, int entryCode, double area, String details, List<String> furnitures, Integer parkingNumber) {
        super(flatNumber, entryCode, area, details, furnitures);
        this.parkingNumber = parkingNumber;
    }

    @Override
    public Double getPrice() {
        return super.getArea() * PRICE_PER_SQUAREMETER;
    }

    public Double getPrice(int tenats) {
        if (tenats > MAX_NUMBER_OF_TENATS) return -1.;
        return super.getArea() * PRICE_PER_SQUAREMETER / tenats;
    }

    public Integer getParkingNumber() {
        return parkingNumber;
    }

    public void setParkingNumber(Integer parkingNumber) {
        this.parkingNumber = parkingNumber;
    }

    @Override
    public String toString() {
        return super.toString().replaceFirst(".$", "") + ", parking number=" + parkingNumber + '}';

    }
}
