package org.wecancoeit.reviews;

public class EnergyDrink {

    private Long id;
    private String brand;
    private String flavor;
    private String description;
    private String imgUrl;

    public Long getId() {
        return id;
    }

    public String getBrand(){
        return brand;
    }

    public String getFlavor(){
        return flavor;
    }

    public String getDescription(){
        return description;
    }

    public String getImgUrl(){ return imgUrl; }

    public EnergyDrink(long id, String brand, String flavor, String description, String imgUrl) {
        this.id = id;
        this.brand = brand;
        this.flavor = flavor;
        this.description = description;
        this.imgUrl = imgUrl;
    }

}
