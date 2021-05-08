package Dynamic;

public class Supervisor extends Person {

    private Integer salary;

    public Supervisor(Person p, Integer salary) {
        super(p.getFirstName(), p.getLastName());
        this.salary = salary;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + " " + getSalary();
    }
}
