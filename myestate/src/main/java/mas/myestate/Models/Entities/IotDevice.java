package mas.myestate.Models.Entities;


import javax.persistence.*;
import java.util.List;

@Entity
public class IotDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @ManyToMany
    private List<Flat> inFlats;

    public IotDevice() {
    }

    public IotDevice(String name, Double price) {
        this.name = name;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Flat> getInFlats() {
        return inFlats;
    }

    public void setInFlats(List<Flat> inFlats) {
        this.inFlats = inFlats;
    }
}
