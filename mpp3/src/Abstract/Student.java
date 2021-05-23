package Abstract;

import java.time.LocalDate;

public class Student extends Person {

    private String studentNr;
    private LocalDate startDate;

    public Student(String name, Integer age, String studentNr, LocalDate startDate) {
        super(name, age);
        this.studentNr = studentNr;
        this.startDate = startDate;
    }

    @Override
    public String sayHello() {
        return super.sayHello() + " studentem " + studentNr;
    }
}
