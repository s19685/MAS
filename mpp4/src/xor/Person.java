package xor;

public class Person {

    private String firstName;
    private String lastName;

    private Estate ownedEstate;
    private Apartment ownedApartment;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public Estate getOwnedEstate() {
        return ownedEstate;
    }

    public void setOwnedEstate(Estate ownedEstate) throws Exception {
        if(ownedApartment != null) throw new Exception("Cant be owner of both Estate and Apartment");

        this.ownedEstate = ownedEstate;
        ownedEstate.setOwner(this);
    }

    public Apartment getOwnedApartment() {
        return ownedApartment;
    }

    public void setOwnedApartment(Apartment ownedApartment) throws Exception {
        if(ownedEstate != null) throw new Exception("Cant be owner of both Estate and Apartment");

        this.ownedApartment = ownedApartment;
        ownedApartment.setOwner(this);
    }
}
