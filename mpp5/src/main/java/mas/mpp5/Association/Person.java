package mas.mpp5.Association;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "person", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Apartment> ownedApartments = new ArrayList<>();

    public Person(){
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Apartment> getOwnedApartments() {
        return ownedApartments;
    }

    public void setOwnedApartments(List<Apartment> ownedApartments) {
        this.ownedApartments = ownedApartments;
    }

    public void addOwnedApartment(Apartment apartment) {
        ownedApartments.add(apartment);
        apartment.setPerson(this);
    }


}
