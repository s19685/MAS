package Multinheritance;

public class PoolHouse implements Poolable {

    double poolSize;

    public PoolHouse(double poolSize) {
        this.poolSize = poolSize;
    }

    @Override
    public double getPoolSize() {
        return 0;
    }

    @Override
    public void setPoolSize(double size) {

    }
}
