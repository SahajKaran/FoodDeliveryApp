package com.example.fooddeliveryapp.entities;

public class PopularFood {
    String name;
    String price;
    int imageUrl;

    public PopularFood(String name, String price, Integer imageUrl) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getName () {
        return name;
    }
    public void setName (String name) {
        this.name = name;
    }

    public String getPrice () {
        return price;
    }
    public void setPrice (String price) {
        this.price = price;
    }

    public int getImageUrl () {
        return imageUrl;
    }

    public void setImageUrl (int url) {
        this.imageUrl = url;
    }


}
