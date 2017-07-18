package com.spring62.phone.model;


public class ModelPhone {
    
    private String  name         = null; // `name`         VARCHAR(20) 
    private String  manufacturer = null; // `manufacturer` VARCHAR(40) 
    private Integer price        = null; // `price`        INT(11)
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "ModelPhone [name=" + name + ", manufacturer=" + manufacturer
                + ", price=" + price + "]";
    }
    public ModelPhone() {
        super();
    }
    public ModelPhone(String name, String manufacturer, Integer price) {
        super();
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
    }
    
    
    
}
