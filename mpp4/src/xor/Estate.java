package xor;


import java.util.ArrayList;
import java.util.List;

public class Estate {

    private String name;
    private List<Apartment> apartments;

    private Person owner;

    public Estate(String name) {
        this.name = name;
        apartments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addApartment(Apartment apartment) {
        apartments.add(apartment);
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}

