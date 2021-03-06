package mas.myestate.Models.Entities;

import mas.myestate.Models.Enums.State;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "flat_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private int flatNumber;

    @Column(nullable = false)
    private String entrycode;

    @Column(nullable = false)
    private String details;

    @Column(nullable = false)
    private Integer roomsNumber;

    @Column(nullable = false)
    private Double area;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Boolean isDeleted = false;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private State state;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Resident owner;

    @ManyToOne
    @JoinColumn(name = "building_id", referencedColumnName = "id")
    private Building building;

    @OneToMany
    @JoinColumn(name = "rental_id", referencedColumnName = "id")
    private List<Rental> rentals;

    @ManyToMany
    private List<IotDevice> devices;

    @ManyToMany
    private List<Furniture> furnitures;

    public Flat() {}

    public Flat(int flatNumber, String entrycode, String details, Integer roomsNumber,
                Double area, Double price, Building building) {
        this.state = State.FOR_SALE;
        this.flatNumber = flatNumber;
        this.entrycode = entrycode;
        this.details = details;
        this.roomsNumber = roomsNumber;
        this.area = area;
        this.price = price;
        this.building = building;
        furnitures = new ArrayList<>();
    }

//    public static Flat createFlat(int flatNumber, String entrycode, String details, Integer roomsNumber,
//                                  Double area, Double price, Building building) throws Exception {
//        if(building ==null) throw new Exception("Building does not exists");
//        Flat flat = new Flat() {
//        }
//    }



    public String getName(){
        return this.getClass().getSimpleName() + " " + getRoomsNumber() + " pokoje";
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getEntrycode() {
        return entrycode;
    }

    public void setEntrycode(String entrycode) {
        this.entrycode = entrycode;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getRoomsNumber() {
        return roomsNumber;
    }

    public void setRoomsNumber(Integer roomsNumber) {
        this.roomsNumber = roomsNumber;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Resident getOwner() {
        return owner;
    }

    public void setOwner(Resident owner) {
        this.owner = owner;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public List<IotDevice> getDevices() {
        return devices;
    }

    public void setDevices(List<IotDevice> devices) {
        this.devices = devices;
        for (IotDevice d : devices)  d.addToinFlats(this);
    }

    public List<Furniture> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(List<Furniture> furnitures) {
        this.furnitures = furnitures;
    }

    public void addFurnitures(List<Furniture> furnitures) {
        for (Furniture f : furnitures){
            this.furnitures.add(f);
            f.addToinFlats(this);
        }
    }

}
