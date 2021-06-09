package mas.mpp5;


import mas.mpp5.Association.ApartamentRepo;
import mas.mpp5.Association.Apartment;
import mas.mpp5.Class.Furniture;
import mas.mpp5.Class.FurnitureRepo;
import mas.mpp5.Association.Person;
import mas.mpp5.Inheritance.FlatRepo;
import mas.mpp5.Association.PersonRepo;
import mas.mpp5.Inheritance.Studio;
import mas.mpp5.Inheritance.Villa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Transactional
@Component
public class DbSeeder implements CommandLineRunner {

    private PersonRepo personRepo;
    private FlatRepo flatRepo;
    private FurnitureRepo furnitureRepo;
    private ApartamentRepo apartamentRepo;


    @Autowired
    public DbSeeder(PersonRepo personRepo, FlatRepo flatRepo, FurnitureRepo furnitureRepo,ApartamentRepo apartamentRepo) {
        this.personRepo = personRepo;
        this.flatRepo = flatRepo;
        this.furnitureRepo = furnitureRepo;
        this.apartamentRepo = apartamentRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        //Class

        for (int i =0; i<10;i++) {
            furnitureRepo.save(new Furniture("Krzeslo",Math.random()*50,50,50));
        }

        //Association

        Person adam = new Person("Adam", "Klips");
        Person karol = new Person("Karol", "Kondrat");
        Person ada = new Person("Ada", "Klis");

        Apartment luxury =new Apartment(34, 140,52,true);
        Apartment studio =new Apartment(24, 80,12,false);

        Apartment luxury1 =new Apartment(43, 140,11,true);
        Apartment studio1 =new Apartment(55, 80,33,false);

        adam.addOwnedApartment(luxury);
        karol.addOwnedApartment(studio);

        ada.addOwnedApartment(luxury1);
        ada.addOwnedApartment(studio1);

        personRepo.save(ada);
        personRepo.save(karol);
        personRepo.save(adam);

        apartamentRepo.save(luxury);
        apartamentRepo.save(luxury1);
        apartamentRepo.save(studio);
        apartamentRepo.save(studio1);

        //Inheritance

        for (int i =1; i<6;i++) {
            flatRepo.save(new Studio(i, i * 40,null,5+i,false));
            flatRepo.save(new Villa(i+30,i*50,null,i,true));
        }

    }
}
