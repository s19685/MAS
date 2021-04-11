import java.io.*;
import java.util.Arrays;

public class Main {

    private static final String FILE_NAME = "data.ser";

    public static void main(String[] args) {

        if (new File(FILE_NAME).exists()) {
            System.out.println("==========LOAD=============");
            deserializeObjects();
        } else {
            System.out.println("==========CREATE===========");
            createObjects();
            System.out.println("==========WRITE============");
            serializeObjects();
        }

        System.out.println("==========SHOW=============");
        Flat.showExtent();

        System.out.println("==========SHOW=============");
        System.out.println("normal price " + Flat.getListOfFlats().get(1).getPrice());
        System.out.println("price per person " + ((Apartment) Flat.getListOfFlats().get(1)).getPrice(5));
    }

    private static void createObjects() {
        new Flat(23, 8921, 100.50, "fajny domek", Arrays.asList("stolik nocny", "lóżko", "lodówka"));
        new Apartment(31, 8011, 300.50, "super domek", Arrays.asList("stolik nocny", "lóżko", "lodówka", "kominek"), 3);
        new Apartment(3, 2651, 900.50, "duzy domek", Arrays.asList("stolik nocny", "lóżko", "lodówka", "wanna"));
    }

    private static void serializeObjects() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            Flat.writeExtent(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deserializeObjects() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
            Flat.readExtent(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
