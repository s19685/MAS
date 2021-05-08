package Multinheritance;

public class PoolHouse implements Poolable {

    double poolSize;

    public PoolHouse(double poolSize) {
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
               getClass().getInterfaces()[0].getSimpleName() + " " +
               poolSize;
    }
}
