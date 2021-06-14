package mas.myestate.Models.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Building {

    public static final int MIN_FLAT_COUNT = 50;
    public static final int MAX_FLAT_COUNT = 80;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Boolean isDeleted = false;

    @ManyToOne
    @JoinColumn(name = "estate_id", referencedColumnName = "id")
    private Estate estate;

    @OneToMany(mappedBy = "building")
    private List<Board> boards;

    @OneToMany(mappedBy = "building")
    private List<Flat> flats;

    private Building() {
    }

    private Building(String name, String address, Estate estate) {
        this.name = name;
        this.address = address;
        this.estate = estate;
        flats = new ArrayList<>();
    }

    public static Building createBuilding(String name, String address, Estate estate) throws Exception {
        if(estate == null) throw new Exception("Estate does not exists");
        Building building = new Building(name,address,estate);
        estate.addBuilding(building);
        return building;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
    }

    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }

    public List<Flat> getFlats() {
        return flats;
    }

    public void setFlats(List<Flat> flats) throws Exception {
        if(flats.size() < MIN_FLAT_COUNT || flats.size() >MAX_FLAT_COUNT ) throw new Exception("Too much flats");
        this.flats = flats;
    }

    public void addFlat(Flat flat) throws Exception {
        if(flats.size() == MAX_FLAT_COUNT ) throw new Exception("Could not add more flats");
        flats.add(flat);
    }

    public void deleteBuilding() {
        for (Flat f : flats) f.setDeleted(true);
        setDeleted(true);

    }
}
