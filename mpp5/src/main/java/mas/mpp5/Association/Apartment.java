package mas.mpp5.Association;

import javax.persistence.*;

@Entity
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private int flatNumber;

    @Column(nullable = false)
    private double area;
    @Column(nullable = false)
    private int parkingNumber;

    @Column(nullable = false)
    private boolean hasBalcony;

    @ManyToOne(cascade ={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Person person;

    public Apartment(){
    }

    public Apartment(int flatNumber, double area, int parkingNumber, boolean hasBalcony) {
        this.flatNumber = flatNumber;
        this.area = area;
        this.parkingNumber = parkingNumber;
        this.hasBalcony = hasBalcony;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public int getFlatNumber() { return flatNumber; }

    public void setFlatNumber(int flatNumber) { this.flatNumber = flatNumber; }

    public double getArea() { return area; }

    public void setArea(double area) { this.area = area; }

    public int getParkingNumber() {
        return parkingNumber;
    }

    public void setParkingNumber(int parkingNumber) {
        this.parkingNumber = parkingNumber;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
