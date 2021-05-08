package Multiaspect;

public class Flat {

    private int flatNumber;
    private double area;
    private String details;

    private boolean isMultiFloored;

    //MULTIFLOORED
    private int floorsNumber;

    //SINGLEFLOORED
    private String discountCode;

    public Flat(int flatNumber, double area, String details, boolean isMultiFloored) {
        this.flatNumber = flatNumber;
        this.area = area;
        this.details = details;
        this.isMultiFloored = isMultiFloored;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isMultiFloored() {
        return isMultiFloored;
    }

    public void setMultiFloored(boolean multiFloored) {
        isMultiFloored = multiFloored;
    }

    public int getFloorsNumber() throws Exception {
        if (!isMultiFloored) throw new Exception("Single floor flat");

        return floorsNumber;
    }

    public void setFloorsNumber(int floorsNumber) throws Exception {
        if (!isMultiFloored) throw new Exception("Single floor flat");

        this.floorsNumber = floorsNumber;
    }

    public String getDiscountCode() throws Exception {
        if (isMultiFloored) throw new Exception("Discounts do not apply to multi-storey apartments");

        return discountCode;
    }

    public void setDiscountCode(String discountCode) throws Exception {
        if (isMultiFloored) throw new Exception("Discounts do not apply to multi-storey apartments");

        this.discountCode = discountCode;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+
                "{" +
                "flatNumber=" + flatNumber +
                ", area=" + area +
                ", details='" + details + '\'' +
                ", isMultiFloored=" + isMultiFloored +
                ", floorsNumber=" + floorsNumber +
                ", discountCode='" + discountCode + '\'' +
                '}';
    }
}
