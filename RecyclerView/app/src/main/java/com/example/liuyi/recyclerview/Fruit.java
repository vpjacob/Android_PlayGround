package com.example.liuyi.recyclerview;

/**
 * Created by liuyi on 2017/8/14.
 */

public class Fruit {
    private String name;
    private int imageId;
    public Fruit (String name,int ImageId){
        this.name = name;
        this.imageId = ImageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
