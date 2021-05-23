import Abstract.Person;
import Abstract.Student;
import Abstract.Teacher;
import Dynamic.FlatOwner;
import Dynamic.Supervisor;
import Multiaspect.Flat;
import Multinheritance.Apartment;
import Multinheritance.PoolHouse;
import Multinheritance.Villa;
import Overlapping.PersonType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        testAbstract();

        testOverlapping();

        testMultiInheritance();

        testMultiAspect();

        testDynamic();
    }

    private static void testMultiAspect() throws Exception {
        System.out.println("================MULTIASPECT======================");

        Flat flat = new Flat(65,70.0,"Default flat",false);
        flat.setDiscountCode("KOD");
        Multiaspect.Villa villa = new Multiaspect.Villa(43,900,"Winter villa", true,"Janek");
        villa.setFloorsNumber(4);
        Multiaspect.Apartment apartment = new Multiaspect.Apartment(45,213,"Studio Apartment",
                                                                  false,4,true);
        apartment.setDiscountCode("KOD2");

        System.out.println(flat);
        System.out.println(villa);
        System.out.println(apartment);
        System.out.println();
    }

    private static void testMultiInheritance() {
        System.out.println("==============MULTINHERITANCE====================");

        Apartment apartment =  new Apartment(43,350.60,"Top floor apartment");
        PoolHouse poolHouse = new PoolHouse(50.50);
        Villa villa = new Villa(30,500,"Summer Villa", "Antek",90.80);

        System.out.println(apartment);
        System.out.println(poolHouse);
        System.out.println(villa);

        poolHouse.setPoolSize(70.9);
        System.out.println(poolHouse.getPoolSize());
        System.out.println();
    }

    private static void testOverlapping() throws Exception {
        System.out.println("================OVERLAPPING======================");

        Overlapping.Person person = new Overlapping.Person("Jan", "Klops");
        System.out.println(person);

        Overlapping.Person flatOwner = new Overlapping.Person("Karol", "Jok", "1464");
        System.out.println(flatOwner);

        Overlapping.Person supervisor = new Overlapping.Person("Andrzej", "Klips", 1500);
        System.out.println(supervisor);

        supervisor.addType(PersonType.FLAT_OWNER);
        supervisor.setAccountNumber("314135315");
        System.out.println(supervisor);
        System.out.println();
    }

    private static void testDynamic() {
        System.out.println("==================DYNAMIC========================");

        Dynamic.Person person = new Dynamic.Person("alan", "alanski");
        System.out.println(person);

        Supervisor supervisor = new Supervisor(person,1000);
        System.out.println(supervisor);

        FlatOwner flatOwner = new FlatOwner(supervisor, "12435314134");
        supervisor = null;
        System.out.println(flatOwner);
        System.out.println(supervisor);
        System.out.println();
    }

    private static void testAbstract() {
        System.out.println("=================ABSTRACT========================");

        List<Person> people = new ArrayList<>();

        Person person = new Student("adam", 21,"s123", LocalDate.now());
        Student student = new Student("daniel", 21,"s1223", LocalDate.now());
        Teacher teacher = new Teacher("daniel", 21,"doktor",12000);
        people.addAll(Arrays.asList(person,student,teacher));

        for (Person p : people) System.out.println(p.sayHello());
        System.out.println();
    }
}
