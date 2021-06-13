package mas.myestate.Models.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Furniture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double height;

    @Column(nullable = false)
    private Double width;

    @Column(nullable = false)
    private Double length;

    @ManyToMany
    private List<Flat> inFlats;

    public Furniture() {
    }

    public Furniture(String name, Double height, Double width, Double length) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.length = length;
        this.inFlats = new ArrayList<>();

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

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public List<Flat> getInFlats() {
        return inFlats;
    }

    public void setInFlats(List<Flat> inFlats) {
        this.inFlats = inFlats;
    }

    public void addToinFlats(Flat flat) {
        this.inFlats.add(flat);
    }
}
