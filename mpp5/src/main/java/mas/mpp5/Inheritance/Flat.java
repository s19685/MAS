package mas.mpp5.Inheritance;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "flat_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Flat {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "FLAT_ID")
    private Long id;

    @Column(nullable = false)
    private int flatNumber;

    @Column(nullable = false)
    private double area;

    @Column(nullable = true)
    private String name;

    public Flat() {
    }

    public Flat(int flatNumber, double area, String name) {
        this.flatNumber = flatNumber;
        this.area = area;
        this.name = name;
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

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
