package Abstract;

public class Teacher extends Person {

    private String scienceTitle;
    private Integer salary;


    public Teacher(String name, Integer age, String scienceTitle, Integer salary) {
        super(name, age);
        this.scienceTitle = scienceTitle;
        this.salary = salary;
    }

    @Override
    public String sayHello() {
        return super.sayHello() + " nauczycielem " + scienceTitle;
    }
}
