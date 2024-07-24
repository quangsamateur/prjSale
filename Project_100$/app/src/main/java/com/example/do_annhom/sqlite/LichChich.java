package com.example.do_annhom.sqlite;

import java.io.Serializable;

public class LichChich implements Serializable {
    int id;
    String tenmuitiem;
    String tenvacxin;
    public LichChich()
    {

    }

    public LichChich(int id, String tenmuitiem, String tenvacxin, String ngaytiem, String tuoi, String muiso, String cosoitem, String ghichu, String giotiem) {
        this.id = id;
        this.tenmuitiem = tenmuitiem;
        this.tenvacxin = tenvacxin;
        this.ngaytiem = ngaytiem;
        this.tuoi = tuoi;
        this.muiso = muiso;
        this.cosoitem = cosoitem;
        this.ghichu = ghichu;
        this.giotiem = giotiem;
    }

    String ngaytiem;



    String tuoi;
    String muiso;
    String cosoitem;
    String ghichu;
    String giotiem;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenmuitiem() {
        return tenmuitiem;
    }

    public void setTenmuitiem(String tenmuitiem) {
        this.tenmuitiem = tenmuitiem;
    }

    public String getTenvacxin() {
        return tenvacxin;
    }

    public void setTenvacxin(String tenvacxin) {
        this.tenvacxin = tenvacxin;
    }

    public String getNgaytiem() {
        return ngaytiem;
    }

    public void setNgaytiem(String ngaytiem) {
        this.ngaytiem = ngaytiem;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public String getMuiso() {
        return muiso;
    }

    public void setMuiso(String muiso) {
        this.muiso = muiso;
    }

    public String getCosoitem() {
        return cosoitem;
    }

    public void setCosoitem(String cosoitem) {
        this.cosoitem = cosoitem;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }




    public String getGiotiem() {
        return giotiem;
    }

    public void setGiotiem(String giotiem) {
        this.giotiem = giotiem;
    }
}
