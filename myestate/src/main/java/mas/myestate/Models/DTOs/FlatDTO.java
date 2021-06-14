package mas.myestate.Models.DTOs;

import mas.myestate.Models.Entities.Furniture;

import java.util.List;

public class FlatDTO {

    private Long id;
    private String name;
    private Double area;
    private Double price;
    private String desc;
    private String entryCode;
    private List<FurnitureDTO> furnitures;


    public FlatDTO() {
    }

    public FlatDTO(Long id, String name, Double area, Double price, String desc, String entryCode, List<FurnitureDTO> furnitures) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.price = price;
        this.desc = desc;
        this.entryCode = entryCode;
        this.furnitures = furnitures;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public String getEntryCode() {
        return entryCode;
    }

    public void setEntryCode(String entryCode) {
        this.entryCode = entryCode;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<FurnitureDTO> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(List<FurnitureDTO> furnitures) {
        this.furnitures = furnitures;
    }
}
