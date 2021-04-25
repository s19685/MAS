package kompozycja;

import java.util.ArrayList;
import java.util.List;

public class Building {

    private String name;
    private boolean deleted;

    private List<Apartment> apartments;
    
    private static List<Apartment> allApartments = new ArrayList<>();

    public Building(String name) {
        this.name = name;
        apartments = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public void addApartment(Apartment apartment) throws Exception{
        if(allApartments.contains(apartment)) throw new Exception("Apartment already in building");

        apartments.add(apartment);
        allApartments.add(apartment);
    }

    public void deleteBuilding(){
        for (Apartment a : apartments) {
            a.setDeleted(true);
        }
        this.setDeleted(true);
    }
}
