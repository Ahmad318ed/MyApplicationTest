package com.example.myapplication;

public class Product {

    String name,type;
    String Price;

    public Product() {


    }

    public Product(String name, String type, String price) {
        this.name = name;
        this.type = type;
        Price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
