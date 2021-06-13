package mas.myestate.Models.DTOs;

public class FurnitureDTO {

    private String name;
    private Double height;
    private Double width;
    private Double length;

    public FurnitureDTO() {
    }

    public FurnitureDTO(String name, Double height, Double width, Double length) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }
}
