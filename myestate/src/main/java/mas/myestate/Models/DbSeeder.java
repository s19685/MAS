package mas.myestate.Models;

import mas.myestate.Models.Entities.*;
import mas.myestate.Models.Enums.Role;
import mas.myestate.Models.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    private AnnoucementRepo annoucementRepo;
    private BoardRepo boardRepo;
    private BuildingRepo buildingRepo;
    private EstateRepo estateRepo;
    private FlatRepo flatRepo;
    private FurnitureRepo furnitureRepo;
    private IotDeviceRepo iotDeviceRepo;
    private RentRepo rentRepo;
    private ResidentRepo residentRepo;

    @Autowired
    public DbSeeder(AnnoucementRepo annoucementRepo, BoardRepo boardRepo, BuildingRepo buildingRepo,
                    EstateRepo estateRepo, FlatRepo flatRepo, FurnitureRepo furnitureRepo,
                    IotDeviceRepo iotDeviceRepo, RentRepo rentRepo, ResidentRepo residentRepo) {
        this.annoucementRepo = annoucementRepo;
        this.boardRepo = boardRepo;
        this.buildingRepo = buildingRepo;
        this.estateRepo = estateRepo;
        this.flatRepo = flatRepo;
        this.furnitureRepo = furnitureRepo;
        this.iotDeviceRepo = iotDeviceRepo;
        this.rentRepo = rentRepo;
        this.residentRepo = residentRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        //FURNITURES AND DEVICES

        List<Furniture> furnitures = seedFurnitures();
        furnitureRepo.saveAll(furnitures);

        seedDevices();

        //USERS

        Resident adam = new Resident("Adam", "Ponk");
        Resident karol = new Resident("Karol", "Koral",50.);
        Resident robson =  new Resident("Robert", "Krawc","s89165756713");

        karol.addRole(Role.TENAT);
        residentRepo.save(adam);
        residentRepo.save(karol);
        residentRepo.save(robson);

        //ESTATE

        Estate estate = new Estate("Sezamowe osiedle", "ul. Sezamkowa 3 Warszawa", "533324876");
        estateRepo.save(estate);


        Building building = Building.createBuilding("BLUE", "ul. Sezamkowa 3/A",estate);

        List<Flat> flats = seedFlats(furnitures,building);
        Collections.shuffle(flats);

        buildingRepo.save(building);


        robson.setFlats(flats);

        flatRepo.saveAll(flats);

        //BOARD

        Board board = new Board();
        Annoucement annoucement = Annoucement.createAnn("SMIECI", "wyrzucamy smieci", LocalDate.now(),adam, board);

        board.setBuilding(building);

        boardRepo.save(board);
        annoucementRepo.save(annoucement);

    }


    private List<Flat> seedFlats(List<Furniture> furnitures, Building building) throws Exception {
        List<Flat> flatsList = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            flatsList.add(Apartment.createApartment(i, i + randCode(), "Aparteament 3 pokojowy  z widokiem na morze", 3, 45.50, 150.,building,50+i ));
        }
        for (int i = 1; i <= 10; i++) {
            flatsList.add(Studio.createStudio(i, i + randCode(), "Kawalerka 2 pokojowa z kuchnia", 2, 45.50, 100.,building));
        }
        for (int i = 1; i <= 3; i++) {
            flatsList.add(Penthouse.createPenthouse(i, i + randCode(), "Luksusowy apartament z 4 pokojami z widokiem na morze z basenem", 4, 45.50, 200.,building, true));
        }

        for (Flat f : flatsList) f.addFurnitures(furnitures);

        return flatsList;
    }

    private String randCode() {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            code.append((int) (Math.random() * 10));
        }
        return "#" + code;
    }


    private void seedDevices() {
        IotDevice lamps = new IotDevice("Smart Wifi lamps system", 5.5);
        IotDevice assistant = new IotDevice("Audio assistance", 10.5);
        IotDevice soundSystem = new IotDevice("Wifi sound system ", 15.);

        List<IotDevice> res = Arrays.asList(lamps, assistant, soundSystem);

        iotDeviceRepo.saveAll(res);
    }

    private List<Furniture> seedFurnitures() {
        Furniture table = new Furniture("Talbe", 100., 100., 200.);
        Furniture chair = new Furniture("Chair", 50., 50., 50.);
        Furniture sofa = new Furniture("Sofa", 150., 150., 150.);
        Furniture wardrobe = new Furniture("Wardrobe", 150., 50., 150.);


        return Arrays.asList(table, chair, sofa, wardrobe);
    }
}
