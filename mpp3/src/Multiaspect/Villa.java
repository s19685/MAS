package Multiaspect;

public class Villa extends Flat{

    private String name;


    public Villa(int flatNumber, double area, String details, boolean isMultiFloored, String name) {
        super(flatNumber, area, details, isMultiFloored);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
