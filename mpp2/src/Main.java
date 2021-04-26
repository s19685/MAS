import kwalifikowana.Building;
import z_atrybutem.Apartment;
import z_atrybutem.Tenat;
import z_atrybutem.TenatInApartment;
import zwykla.Flat;
import zwykla.Furniture;

import java.awt.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here

        //atrybut
        Tenat tenat = new Tenat("Jan", "Pan","123123123");
        Apartment apartment = new Apartment(12,40.30,"dobry");

        TenatInApartment tia = new TenatInApartment(tenat,apartment, LocalDate.now());

        System.out.println(tenat.getTenatInApartments().get(0));
        System.out.println(apartment.getTenatInApartments().get(0));


        //kwalifikowana

        Building building = new Building("BLUE");
        kwalifikowana.Apartment apartment1 = new kwalifikowana.Apartment(31,150.50,"znajdz mnie");
        kwalifikowana.Apartment apartment2 = new kwalifikowana.Apartment(1,150.50,"nie mnie");
        kwalifikowana.Apartment apartment3 = new kwalifikowana.Apartment(13,150.50,"nie mnie");

        building.addApartmentQualif(apartment1);
        building.addApartmentQualif(apartment2);
        building.addApartmentQualif(apartment3);

        System.out.println(building.findApartment(31).getDetails());

        //kompozycja

        kompozycja.Building building1 = new kompozycja.Building("TED");

        kompozycja.Apartment.createApartment(41,50,"oki",building1);
        kompozycja.Apartment.createApartment(12,50,"oki2",building1);
//        kompozycja.Apartment.createApartment(12,50,"oki2",null);

//        kompozycja.Building building2 = new kompozycja.Building("RED");
//
//        building2.addApartment(building1.getApartments().get(0));

        for (kompozycja.Apartment a : building1.getApartments()) {
            if(!a.isDeleted()) System.out.println(a.getDetails());
        }
        building1.deleteBuilding();

        System.out.println("po usunieciu");
        for (kompozycja.Apartment a : building1.getApartments()) {
            if(!a.isDeleted()) System.out.println(a.getDetails());
        }

        //zwykla

        Furniture f = new Furniture("szafa",5,5,5);
        Furniture f1 = new Furniture("stol",5,5,5);
        Furniture f2 = new Furniture("wanna",5,5,5);

        List<Furniture> furnitures = Arrays.asList(f,f1,f2);

        Flat flat = new Flat(32,210.60,"flacik", furnitures);
        System.out.println(flat);
        System.out.println(f.getFlat());
        System.out.println(flat.getFurnitures().get(0).getFlat());



    }
}
