package subset;

import java.util.List;

public class Supervisor {

    private String firstName;
    private String lastName;
    private Integer salary;
    private Estate ownedEstate;
    private List<Estate> estates;

    public Supervisor(String firstName, String lastName, Integer salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Estate getOwnedEstate() {
        return ownedEstate;
    }

    public void setOwnedEstate(Estate ownedEstate) throws Exception {
        if(!ownedEstate.getSupervisors().contains(this)){
            throw new Exception("Cant be owner when dont working in this estate");
        }

        this.ownedEstate = ownedEstate;
        ownedEstate.setOwner(this);
    }

    public List<Estate> getEstates() {
        return estates;
    }

    public void setEstates(List<Estate> estates) {
        this.estates = estates;
    }
}
