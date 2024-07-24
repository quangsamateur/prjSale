package com.example.do_annhom.sqlite;

import java.io.Serializable;

public class CanNang implements Serializable {
    int id;
    Double bmi;
    String tb1;
    int cannang;
    int chieucao;
    String ghichu;
    String ngaydo;
    String gioitinh;
    String dotuoi;

    public  CanNang()
    {

    }
    public String getTb1() {
        return tb1;
    }

    public void setTb1(String tb1) {
        this.tb1 = tb1;
    }

    public String getTb2() {
        return tb2;
    }

    public void setTb2(String tb2) {
        this.tb2 = tb2;
    }

    String tb2;
    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public CanNang(int id, int cannang, int chieucao, String ghichu, String ngaydo, String gioitinh, String dotuoi,Double bmi,String tb1,String tb2) {
        this.id = id;
        this.cannang = cannang;
        this.chieucao = chieucao;
        this.ghichu = ghichu;
        this.ngaydo = ngaydo;
        this.gioitinh = gioitinh;
        this.dotuoi = dotuoi;
        this.bmi = bmi;
        this.tb1 = tb1;
        this.tb2 = tb2;

    }

    public int getCannang() {
        return cannang;
    }

    public void setCannang(int cannang) {
        this.cannang = cannang;
    }

    public int getChieucao() {
        return chieucao;
    }

    public void setChieucao(int chieucao) {
        this.chieucao = chieucao;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getNgaydo() {
        return ngaydo;
    }

    public void setNgaydo(String ngaydo) {
        this.ngaydo = ngaydo;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDotuoi() {
        return dotuoi;
    }

    public void setDotuoi(String dotuoi) {
        this.dotuoi = dotuoi;
    }
}
