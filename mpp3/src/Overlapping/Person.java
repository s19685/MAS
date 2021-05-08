package Overlapping;

import java.util.EnumSet;

public class Person {

    private String firstName;
    private String lastName;

    //SUPERVISOR
    private Integer salary;

    //FLAT_OWNER
    private String accountNumber;

    private EnumSet<PersonType> types = EnumSet.of(PersonType.PERSON);

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, Integer salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        types.add(PersonType.SUPERVISOR);
    }

    public Person(String firstName, String lastName, String accountNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        types.add(PersonType.FLAT_OWNER);

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

    public Integer getSalary() throws Exception {
        if(!types.contains(PersonType.SUPERVISOR)) throw new Exception("Not a worker");

        return salary;
    }

    public void setSalary(Integer salary) throws Exception {
        if(!types.contains(PersonType.SUPERVISOR)) throw new Exception("Not a worker");

        this.salary = salary;
    }

    public String getAccountNumber() throws Exception {
        if(!types.contains(PersonType.FLAT_OWNER)) throw new Exception("Not a flat owner");

        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) throws Exception {
        if(!types.contains(PersonType.FLAT_OWNER)) throw new Exception("Not a flat owner");

        this.accountNumber = accountNumber;
    }

    public EnumSet<PersonType> getTypes() {
        return types;
    }

    public void setTypes(EnumSet<PersonType> types) {
        this.types = types;
    }

    public void addType(PersonType type) {
        this.types.add(type);
    }

    @Override
    public String toString() {
        return getTypes()+"{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
