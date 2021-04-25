package kwalifikowana;

import java.util.Map;
import java.util.TreeMap;

public class Building {


    private Map<Integer, Apartment> apartmentQualif;
    private String name;

    public Building(String name) {
        this.name = name;
        apartmentQualif = new TreeMap<>();
    }

    public void addApartmentQualif(Apartment apartment) throws Exception{
        if(!apartmentQualif.containsKey(apartment.getFlatNumber())){
            apartmentQualif.put(apartment.getFlatNumber(), apartment);

            apartment.addBuilding(this);
        }
        else throw new Exception("Apartment already in building");
    }

    public Apartment findApartment(Integer number) throws Exception{
        if(!apartmentQualif.containsKey(number)) throw new Exception("Apartment not exists: "+number);

        return apartmentQualif.get(number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
