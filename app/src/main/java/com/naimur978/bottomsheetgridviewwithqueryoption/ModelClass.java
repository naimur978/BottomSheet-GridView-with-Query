package com.naimur978.bottomsheetgridviewwithqueryoption;

public class ModelClass {

    String name;
    int image;

    ModelClass(String name , int resourceId)
    {
        this.name = name;
        this.image = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
