package Abstract;

public abstract class Person {

    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+
                "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}'+ sayHello();
    }

    public String sayHello(){
        return "jestem";
    }
}
