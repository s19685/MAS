package Multinheritance;

public class Villa extends Apartment implements Poolable {


    private String name;
    private double poolSize;

    public Villa(Integer flatNumber, double area, String details, String name) {
        super(flatNumber, area, details);
        this.name = name;
    }

    @Override
    public double getPoolSize() {
        return this.poolSize;
    }

    @Override
    public void setPoolSize(double size) {
        this.poolSize=size;
    }
}
