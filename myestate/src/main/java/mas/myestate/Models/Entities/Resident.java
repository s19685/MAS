package mas.myestate.Models.Entities;

import mas.myestate.Models.Enums.Role;

import javax.persistence.*;
import java.util.EnumSet;
import java.util.List;

@Entity
public class Resident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String firtName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = true)
    private String phoneNumber;

    @Column(nullable = true)
    private String accountNumber;

    @Column(nullable = true)
    private Double salary;

    @Column(nullable = false)
    private EnumSet<Role> roles = EnumSet.of(Role.RESIDENT);

    @OneToMany(mappedBy = "resident")
    private List<Rental> rentals;

    @OneToMany(mappedBy = "flats")
    private List<Flat> flats;

    public Resident() {}

    public Resident(String firtName, String lastName) {
        this.firtName = firtName;
        this.lastName = lastName;
        roles.add(Role.TENAT);

    }

    public Resident(String firtName, String lastName, String accountNumber) {
        this.firtName = firtName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        roles.add(Role.OWNER);
    }

    public Resident(String firtName, String lastName, Double salary) {
        this.firtName = firtName;
        this.lastName = lastName;
        this.salary = salary;
        roles.add(Role.SUPERVISOR);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public EnumSet<Role> getRoles() {
        return roles;
    }

    public void setRoles(EnumSet<Role> roles) {
        this.roles = roles;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public List<Flat> getFlats() {
        return flats;
    }

    public void setFlats(List<Flat> flats) {
        this.flats = flats;
    }
}
