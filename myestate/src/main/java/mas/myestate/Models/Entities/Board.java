package mas.myestate.Models.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Board {

    public static final int MAX_BOARD_ITEMS = 30;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @OneToMany(mappedBy = "board")
    private List<Annoucement> annoucements = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "building_id", referencedColumnName = "id")
    private Building building;

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

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public void addAnnoucment(Annoucement annoucement) {
        annoucement.setBoard(this);
        annoucements.add(annoucement);
    }
}

