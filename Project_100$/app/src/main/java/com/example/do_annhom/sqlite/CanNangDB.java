package com.example.do_annhom.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class CanNangDB {
    String dbName = "CanNang.db";
    Context context;
    SQLiteDatabase db;
    public CanNangDB(Context context)
    {
        this.context = context;

    }
    public SQLiteDatabase openDB()
    {
        return context.openOrCreateDatabase(dbName,Context.MODE_PRIVATE,null);
    }
    public void createTable()
    {
        String sql = "CREATE TABLE IF NOT EXISTS tblCanNang( ID INTEGER PRIMARY KEY AUTOINCREMENT, CANNANG INTEGER, CHIEUCAO INTEGER," +
                " GHICHU TEXT, NGAYDO TEXT, GIOITINH TEXT, TUOI TEXT, BMI DECIMAL, TB1 TEXT, TB2 TEXT)";
        db = openDB();
        db.execSQL(sql);
        db.close();

    }
    public int countCanNangs()
    {
        String sql = "SELECT COUNT(*) FROM tblCanNang";
        db = openDB();
        Cursor cursor = db.rawQuery(sql,null);
        int count = cursor.getCount();
        return count;
    }
    public ArrayList<CanNang> getCanNangs()
    {
        ArrayList<CanNang> tmp = new ArrayList<>();
        String sql = "SELECT * FROM tblCanNang";
        db = openDB();
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext())
        {
            int id = cursor.getInt(0);
            int cannang = cursor.getInt(1);
            int chieucao = cursor.getInt(2);
            String ghichu = cursor.getString(3);
            String ngaydo = cursor.getString(4);
            String gioitinh = cursor.getString(5);
            String tuoi = cursor.getString(6);
            Double bmi = cursor.getDouble(7);
            String tb1 = cursor.getString(8);
            String tb2 = cursor.getString(9);

            CanNang canNang = new CanNang(id,cannang,chieucao,ghichu,ngaydo,gioitinh,tuoi,bmi,tb1,tb2);
            tmp.add(canNang);
        }
        db.close();
        return tmp;
    }
    public void insertCanNang(int cannang, int chieucao, String ghichu, String ngaydo, String gioitinh, String tuoi,Double bmi,String tb1, String tb2)
    {
        db= openDB();
        ContentValues cv = new ContentValues();
        cv.put("CANNANG",cannang);
        cv.put("CHIEUCAO",chieucao);
        cv.put("GHICHU",ghichu);
        cv.put("NGAYDO",ngaydo);
        cv.put("GIOITINH",gioitinh);
        cv.put("TUOI",tuoi);
        cv.put("BMI",bmi);
        cv.put("TB1",tb1);
        cv.put("TB2",tb2);
        db.insert("tblCanNang",null,cv);
        db.close();
    }
    public void updateCanNang(int id,int newCanNang, int newChieuCao, String newGhiChu, String newNgayDo, String newGioiTinh, String newTuoi,Double newBMI,String newtb1, String newtb2)
    {
        db = openDB();
        ContentValues cv = new ContentValues();
        cv.put("CANNANG",newCanNang);
        cv.put("CHIEUCAO",newChieuCao);
        cv.put("GHICHU",newGhiChu);
        cv.put("NGAYDO",newNgayDo);
        cv.put("GIOITINH",newGioiTinh);
        cv.put("TUOI",newTuoi);
        cv.put("BMI",newBMI);
        cv.put("TB1",newtb1);
        cv.put("TB2",newtb2);
        db.update("tblCanNang",cv,"ID = " +id,null);

        db.close();
    }

    public void delete(int id)
    {
        db = openDB();
        db.delete("tblCanNang","ID =" + id,null);
        db.close();
    }
}
