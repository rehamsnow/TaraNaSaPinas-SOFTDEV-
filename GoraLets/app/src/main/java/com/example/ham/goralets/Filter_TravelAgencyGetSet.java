package com.example.ham.goralets;

/**
 * Created by Ham on 3/2/2018.
 */

public class Filter_TravelAgencyGetSet {
    private String img;
    private String name;
    private int review;
    private int stars;

    public Filter_TravelAgencyGetSet (String img, String name, int review, int stars){
        this.name = name;
        this.review = review;
        this.stars = stars;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public int getReview() {
        return review;
    }

    public int getStars() {
        return stars;
    }
}
