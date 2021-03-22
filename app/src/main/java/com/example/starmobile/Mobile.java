package com.example.starmobile;

public class Mobile {
   private String name;
   private String image;
   private String brand;
   private String price;
   private Long rating;
   private Long orderLeft;

    public Mobile(){

    }

    public Mobile(String name, String image, String brand, String price, Long rating, Long orderLeft) {
        this.name = name;
        this.image = image;
        this.brand = brand;
        this.price = price;
        this.rating = rating;
        this.orderLeft = orderLeft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public Long getOrderLeft() {
        return orderLeft;
    }

    public void setOrderLeft(Long orderLeft) {
        this.orderLeft = orderLeft;
    }
}
