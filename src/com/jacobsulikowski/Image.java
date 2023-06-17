package com.jacobsulikowski;

import java.io.File;

public class Image {
    private File path;
    private String year;
    private String month;

    public Image(File _path,String _year,String _month){
        this.path = _path;
        this.year = _year;
        this.month = _month;
    }

    public File getPath() {
        return path;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }
}
