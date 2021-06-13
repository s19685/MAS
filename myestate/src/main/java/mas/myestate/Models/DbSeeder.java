package mas.myestate.Models;

import mas.myestate.Models.Entities.*;
import mas.myestate.Models.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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

        residentRepo.save(adam);
        residentRepo.save(karol);
        residentRepo.save(robson);

        //ESTATE

        Estate estate = new Estate("Sezamowe osiedle", "ul. Sezamkowa 3 Warszawa", "533324876");
        estateRepo.save(estate);

        List<Flat> flats =  seedFlats(furnitures);
        Building building = new Building("BLUE", "ul. Sezamkowa 3/A",estate,flats);
        buildingRepo.save(building);

        robson.setFlats(flats);

        flatRepo.saveAll(flats);

        //BOARD

        Board board = new Board();
        Annoucement annoucement = new Annoucement("SMIECI", "wyrzucamy smieci", LocalDate.now(),adam);

        board.addAnnoucment(annoucement);
        board.setBuilding(building);

        boardRepo.save(board);
        annoucementRepo.save(annoucement);

    }


    private List<Flat> seedFlats(List<Furniture> furnitures) {
        List<Flat> flatsList = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            flatsList.add(new Apartment(i, i + randCode(), "Aparteament 3 pokojowy  z widokiem na morze", 3, 45.50, 2000.,50+i ));
        }
        for (int i = 1; i <= 10; i++) {
            flatsList.add(new Studio(i, i + randCode(), "Kawalerka 2 pokojowa z kuchnia", 2, 45.50, 2000.));
        }
        for (int i = 1; i <= 3; i++) {
            flatsList.add(new Penthouse(i, i + randCode(), "Luksusowy apartament z 4 pokojami z widokiem na morze z basenem", 4, 45.50, 2000., true));
        }

        flatsList.get(0).addFurnitures(furnitures);

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
        IotDevice lamps = new IotDevice("Smart Wifi lamps system", 50.);
        IotDevice assistant = new IotDevice("Audio assistance", 50.);
        IotDevice soundSystem = new IotDevice("Wifi sound system ", 150.);

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
