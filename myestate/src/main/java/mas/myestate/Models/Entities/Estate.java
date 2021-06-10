package mas.myestate.Models.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Estate {

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

    @OneToMany(mappedBy = "estate")
    private List<Building> buildings;


    public Estate() {}

    public Estate(String name, String localization, String phoneNumber, List<Building> buildings) {
        this.name = name;
        this.localization = localization;
        this.phoneNumber = phoneNumber;
        this.buildings = buildings;
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

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }
}


