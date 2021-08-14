package com.example.svgpathsetting;
import java.nio.charset.StandardCharsets;

public class PathData {

    public byte[] data;
    public int color;


    public PathData(byte[] data, int color) {
        this.data = data;
        this.color = color;
    }

    public PathData(String data, int color) {
        this(data.getBytes(StandardCharsets.UTF_8), color);
    }

}