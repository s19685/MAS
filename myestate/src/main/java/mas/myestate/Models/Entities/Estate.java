package mas.myestate.Models.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estate {

    public static final int MAX_BUILDING_COUNT = 10;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String localization;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private Boolean isDeleted = false;

    @OneToMany(mappedBy = "estate")
    private List<Building> buildings;


    public Estate() {
    }

    public Estate(String name, String localization, String phoneNumber) {
        this.name = name;
        this.localization = localization;
        this.phoneNumber = phoneNumber;
        buildings = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) throws Exception {
        if (buildings.size() > MAX_BUILDING_COUNT) throw new Exception("Too much buildings");
        this.buildings = buildings;
    }

    public void addBuilding(Building building) throws Exception {
        if (buildings.size() == MAX_BUILDING_COUNT) throw new Exception("Could not insert more buildings");
        buildings.add(building);
    }

    public void deleteEstate() throws Exception {
        for (Building b : buildings) {
            b.deleteBuilding();
        }
        setDeleted(true);
    }


}


