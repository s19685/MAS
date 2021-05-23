package subset;

import unique.Apartment;

import java.util.ArrayList;
import java.util.List;

public class Estate {

    private String Name;
    private List<Apartment> apartments;
    private Supervisor owner;
    private List<Supervisor> supervisors;

    public Estate(String name) {
        Name = name;
        apartments = new ArrayList<>();
        supervisors = new ArrayList<>();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public Supervisor getOwner() {
        return owner;
    }

    public void setOwner(Supervisor owner) {
        this.owner = owner;
    }

    public List<Supervisor> getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(List<Supervisor> supervisors) {
        this.supervisors = supervisors;
    }
}
