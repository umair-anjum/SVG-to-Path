package com.example.svgpathsetting;


import java.util.List;

public class ExampleSVG {

    private String androidwidth;

    private String androidheight;

    private String androidviewportWidth;

    private String androidviewportHeight;

    private List<Pathold> path = null;

    public String getAndroidwidth() {
        return androidwidth;
    }

    public void setAndroidwidth(String androidwidth) {
        this.androidwidth = androidwidth;
    }

    public String getAndroidheight() {
        return androidheight;
    }

    public void setAndroidheight(String androidheight) {
        this.androidheight = androidheight;
    }

    public String getAndroidviewportWidth() {
        return androidviewportWidth;
    }

    public void setAndroidviewportWidth(String androidviewportWidth) {
        this.androidviewportWidth = androidviewportWidth;
    }

    public String getAndroidviewportHeight() {
        return androidviewportHeight;
    }

    public void setAndroidviewportHeight(String androidviewportHeight) {
        this.androidviewportHeight = androidviewportHeight;
    }

    public List<Pathold> getPath() {
        return path;
    }

    public void setPath(List<Pathold> path) {
        this.path = path;
    }

}