import ordered.Apartment;
import ordered.Estate;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Estate estate = new Estate("Brzoza");

        for (int i = 1; i < 16; i++) {
            estate.addApartment(new Apartment(i,50-i,45.50));
        }

        for (Apartment a : estate.getApartments()) {
            System.out.println(a);
        }
    }
}
