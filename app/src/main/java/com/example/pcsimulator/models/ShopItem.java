package com.example.pcsimulator.models;

public class ShopItem {
    private int id;
    private int category;
    private String name;
    private String price;
    private int img;

    private String name1;
    private String prop1;
    private String name2;
    private String prop2;
    private String name3;
    private String prop3;

    public ShopItem(int id, int category, String name, String price, int img, String name1, String prop1, String name2, String prop2, String name3, String prop3) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.img = img;
        this.name1 = name1;
        this.prop1 = prop1;
        this.name2 = name2;
        this.prop2 = prop2;
        this.name3 = name3;
        this.prop3 = prop3;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getProp1() {
        return prop1;
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getProp2() {
        return prop2;
    }

    public void setProp2(String prop2) {
        this.prop2 = prop2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getProp3() {
        return prop3;
    }

    public void setProp3(String prop3) {
        this.prop3 = prop3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
