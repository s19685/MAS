package mas.myestate.Models.Entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Annoucement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String titile;

    @Column(nullable = false)
    private String  details;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Boolean isDeleted = false;

    @ManyToOne
    @JoinColumn(name = "board_id", referencedColumnName = "id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Resident author;

    private Annoucement(){}

    private Annoucement(String titile, String details, LocalDate date, Resident author,Board board) {
        this.titile = titile;
        this.details = details;
        this.date = date;
        this.author = author;
        this.board = board;
    }

    public static Annoucement createAnn(String titile, String details, LocalDate date, Resident author, Board board) throws Exception {
        if(board == null) throw new Exception("Board does not exists");
        Annoucement  annoucement = new Annoucement(titile,details,date,author,board);
        board.addAnnoucment(annoucement);
        return annoucement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Resident getAuthor() {
        return author;
    }

    public void setAuthor(Resident author) {
        this.author = author;
    }
}
