package com.example.funhouse.mainscreenff;

/**
 * Created by IKra Awaan on 6/19/2018.
 */

public class QuestionModel
{
    String name;
    int image;

    public QuestionModel(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
