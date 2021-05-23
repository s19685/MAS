package ordered;

import java.util.*;

public class Estate {

    private String name;

    private List<Apartment> apartments;

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
        Collections.sort(apartments);
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }
}
