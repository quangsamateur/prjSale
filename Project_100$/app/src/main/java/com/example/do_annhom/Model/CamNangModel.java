package com.example.do_annhom.Model;

public class CamNangModel {
    String title;
    String imgurl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getDesin() {
        return desin;
    }

    public void setDesin(String desin) {
        this.desin = desin;
    }

    String desin;

    public CamNangModel(String title, String imgurl, String desin) {
        this.title = title;
        this.imgurl = imgurl;
        this.desin = desin;
    }
    public CamNangModel()
    {

    }

}
