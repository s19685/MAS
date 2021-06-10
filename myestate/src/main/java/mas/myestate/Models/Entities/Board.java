package mas.myestate.Models.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Board {

    public static final int MAX_BOARD_ITEMS = 30;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @OneToMany(mappedBy = "board")
    private List<Annoucement> annoucements;

    @ManyToMany
    private List<Building> buildings;

    public Board() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Annoucement> getAnnoucements() {
        return annoucements;
    }

    public void setAnnoucements(List<Annoucement> annoucements) {
        this.annoucements = annoucements;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }
}

