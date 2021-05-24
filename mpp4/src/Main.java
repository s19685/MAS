import bag.Tenat;
import bag.TenatInApartment;
import ordered.Apartment;
import ordered.Estate;
import subset.Supervisor;
import xor.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here


        //atrybut

        atrybut.Apartment apartment = new atrybut.Apartment(2,3,313.40);
//        apartment.setArea(5);


        //unique
        unique.Apartment apartment1 = new unique.Apartment(3,3,31);
//        unique.Apartment apartment2 = new unique.Apartment(3,3,31);

        //subset

        subset.Estate estate1 = new subset.Estate("Kilo");
        Supervisor supervisor = new Supervisor("Adam","Właz",5000);

        List<Supervisor> supervisors = new ArrayList<>();

        supervisors.add(supervisor); //to comment

        for (int i = 0; i < 5; i++) {
            supervisors.add(new Supervisor("jan","kowalski",i));
        }
        estate1.setSupervisors(supervisors);

        supervisor.setOwnedEstate(estate1);

        //ordered

        Estate estate = new Estate("Brzoza");

        for (int i = 1; i < 16; i++) {
            estate.addApartment(new Apartment(i,50-i,45.50));
        }

        for (Apartment a : estate.getApartments()) {
            System.out.println(a);
        }

        //bag

        bag.Apartment apartment2 = new bag.Apartment(3,134,"mieszkako");
        Tenat tenat  = new Tenat("jan","pan","123123123");

        TenatInApartment tenatInApartment2 = new TenatInApartment(tenat,apartment2, LocalDate.of(2020,6,13));
        TenatInApartment tenatInApartment = new TenatInApartment(tenat,apartment2, LocalDate.now());

        System.out.println(tenatInApartment);
        System.out.println(tenatInApartment2);

        //xor

        Person person = new Person("Pawel","Polak");

        xor.Estate estate2 = new xor.Estate("Sliwka");
        xor.Apartment apartment3 = new xor.Apartment(12,21,98.9);
        person.setOwnedApartment(apartment3);
//        person.setOwnedEstate(estate2);

        //wlasne

        wlasne.Supervisor supervisor1 = new wlasne.Supervisor("Ola","Kasztan", 3413);
        for (int i = 0; i < 5; i++) {
            supervisor1.addApartment(new wlasne.Apartment(i,34,412));
        }
//        supervisor1.addApartment(new wlasne.Apartment(13,31,545));


    }
}
