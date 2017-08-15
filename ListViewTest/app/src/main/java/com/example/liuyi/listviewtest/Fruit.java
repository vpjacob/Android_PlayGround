package com.example.liuyi.listviewtest;

/**
 * Created by liuyi on 2017/8/8.
 */

public class Fruit {
    public String name;
    private int imageId;

    public Fruit(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }
    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
