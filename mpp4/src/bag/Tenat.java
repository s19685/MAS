package bag;

import java.util.ArrayList;
import java.util.List;

public class Tenat {

    private String firstName;
    private String lastName;
    private String phoneNumber;

    private List<TenatInApartment> tenatInApartments;

    public Tenat(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        tenatInApartments = new ArrayList<>();
    }

    public void addTenatInApartment(TenatInApartment item){
        tenatInApartments.add(item);
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<TenatInApartment> getTenatInApartments() {
        return tenatInApartments;
    }

    public void setTenatInApartments(List<TenatInApartment> tenatInApartments) {
        this.tenatInApartments = tenatInApartments;
    }
}
