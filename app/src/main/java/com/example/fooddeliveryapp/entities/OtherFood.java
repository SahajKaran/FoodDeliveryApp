package com.example.fooddeliveryapp.entities;

public class OtherFood {
    String name;
    String price;
    int imageUrl;
    String rating;
    String restarauntName;

    public OtherFood(String name, String price, Integer imageUrl, String rating, String restarauntName ) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.restarauntName = restarauntName;
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

    public String getRating () {
        return rating;
    }
    public void setRating (String rating) {
        this.rating = rating;
    }

    public String getRestarauntName () {
        return restarauntName;
    }
    public void setRestarauntName (String restarauntName) {
        this.restarauntName = restarauntName;
    }

}
