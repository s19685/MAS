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

    @Column(nullable = false)
    private Boolean isDeleted = false;

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

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public List<Annoucement> getAnnoucements() {
        return annoucements;
    }

    public void setAnnoucements(List<Annoucement> annoucements) throws Exception {
        if(annoucements.size() > MAX_BOARD_ITEMS ) throw new Exception("Too much ann");
        this.annoucements = annoucements;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public void addAnnoucment(Annoucement annoucement) throws Exception {
        if(annoucements.size() == MAX_BOARD_ITEMS ) throw new Exception("Could not add more ann");
        annoucement.setBoard(this);
        annoucements.add(annoucement);
    }

    public void deleteBoard() {

        for (Annoucement a : annoucements) {
            a.setDeleted(true);
        }
        setDeleted(true);
    }


}

