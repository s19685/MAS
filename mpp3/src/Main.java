import Abstract.Person;
import Abstract.Student;
import Abstract.Teacher;
import Dynamic.FlatOwner;
import Dynamic.Supervisor;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        System.out.println("=================ABSTRACT.========================");

        Person person = new Student("adam", 21,"s123", LocalDate.now());
        Student student = new Student("daniel", 21,"s1223", LocalDate.now());
        Teacher teacher = new Teacher("daniel", 21,"s1223",12000);

        System.out.println(person);
        System.out.println(student);
        System.out.println(teacher);

        System.out.println("==================DYNAMIC========================");

        Dynamic.Person person1 = new Dynamic.Person("alan", "alanski");

        System.out.println(person1);

        Supervisor supervisor = new Supervisor(person1,1000);

        System.out.println(supervisor);

        FlatOwner flatOwner = new FlatOwner(supervisor, "12435314134");

        System.out.println(flatOwner);
    }
}
