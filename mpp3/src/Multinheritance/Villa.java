package Multinheritance;

public class Villa extends Apartment implements Poolable {


    private String name;
    private double poolSize;

    public Villa(Integer flatNumber, double area, String details, String name, double poolSize) {
        super(flatNumber, area, details);
        this.name = name;
        this.poolSize = poolSize;
    }

    @Override
    public double getPoolSize() {
        return this.poolSize;
    }

    @Override
    public void setPoolSize(double size) {
        this.poolSize = size;
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + " " +
               getClass().getInterfaces()[0].getSimpleName() +
               super.toString().replaceFirst(".$","")+
               " name='" + name + '\'' +
               ", poolSize=" + poolSize +
               '}';
    }
}
