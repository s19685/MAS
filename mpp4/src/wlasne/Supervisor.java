package wlasne;

import java.util.ArrayList;
import java.util.List;

public class Supervisor {

    private String firstName;
    private String lastName;
    private int salary;

    private List<Apartment> apartments;

    public Supervisor(String firstName, String lastName, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;

        apartments = new ArrayList<>();

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void addApartment(Apartment apartment) throws Exception {
        if (apartments.size() >= 5) throw new Exception("too much Apartments under care");

        apartment.setSupervisor(this);
        apartments.add(apartment);

    }

    public void setApartments(List<Apartment> apartments) throws Exception {
        if (apartments.size() > 5) throw new Exception("too much Apartments under care");

        for (Apartment a : apartments) a.setSupervisor(this);
        this.apartments = apartments;

    }
}
