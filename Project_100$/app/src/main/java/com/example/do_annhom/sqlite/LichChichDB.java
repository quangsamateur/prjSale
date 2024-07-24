package com.example.do_annhom.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class LichChichDB {
    String dbName = "LichChich.db";
    Context context;
    SQLiteDatabase db;
    public LichChichDB(Context context)
    {
        this.context = context;

    }
    public SQLiteDatabase openDB()
    {
        return context.openOrCreateDatabase(dbName,Context.MODE_PRIVATE,null);
    }
    public void createTable()
    {
        String sql = "CREATE TABLE IF NOT EXISTS tblLichChich( ID INTEGER PRIMARY KEY AUTOINCREMENT, TENMUITIEM TEXT, TENVACXIN TEXT," +
                " NGAYTIEM TEXT, TUOI TEXT, MUISO TEXT, COSOITEM TEXT, GHICHU TEXT , GIOTIEM TEXT )";
        db = openDB();
        db.execSQL(sql);
        db.close();

    }
    public int countLichChiches()
    {
        String sql = "SELECT COUNT(*) FROM tblLichChich";
        db = openDB();
        Cursor cursor = db.rawQuery(sql,null);
        int count = cursor.getCount();
        return count;
    }
    public ArrayList<LichChich> getLichChiches()
    {
        ArrayList<LichChich> tmp = new ArrayList<>();
        String sql = "SELECT * FROM tblLichChich";
        db = openDB();
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext())
        {
            int id = cursor.getInt(0);
            String tenmuitiem = cursor.getString(1);
            String tenvacxin = cursor.getString(2);
            String ngaytiem = cursor.getString(3);
            String tuoi = cursor.getString(4);
            String muiso = cursor.getString(5);
            String cosoitem = cursor.getString(6);
            String ghichu = cursor.getString(7);
            String giotiem = cursor.getString(8);

            LichChich lichChich = new LichChich(id,tenmuitiem,tenvacxin,ngaytiem,tuoi,muiso,cosoitem,ghichu,giotiem);
            tmp.add(lichChich);
        }
        db.close();
        return tmp;
    }
    public void insertLichChich(String tenmuitiem, String tenvacxin, String ngaytiem, String tuoi, String muiso, String cosoitem, String ghichu, String giotiem)
    {
        db= openDB();
        ContentValues cv = new ContentValues();
        cv.put("TENMUITIEM",tenmuitiem);
        cv.put("TENVACXIN",tenvacxin);
        cv.put("NGAYTIEM",ngaytiem);
        cv.put("TUOI",tuoi);
        cv.put("MUISO",muiso);
        cv.put("COSOITEM",cosoitem);
        cv.put("GHICHU",ghichu);
        cv.put("GIOTIEM",giotiem);
        db.insert("tblLichChich",null,cv);
        db.close();
    }
    public void updateLichChich(int id,String newTenmuitiem, String newTenvacxin, String newNgaytiem, String newTuoi, String newMuiso, String newCosoitem, String newGhichu, String newGiotiem)
    {
        db = openDB();
        ContentValues cv = new ContentValues();
        cv.put("TENMUITIEM",newTenmuitiem);
        cv.put("TENVACXIN",newTenvacxin);
        cv.put("NGAYTIEM",newNgaytiem);
        cv.put("TUOI",newTuoi);
        cv.put("MUISO",newMuiso);
        cv.put("COSOITEM",newCosoitem);
        cv.put("GHICHU",newGhichu);
        cv.put("GIOTIEM",newGiotiem);
        db.update("tblLichChich",cv,"ID = " +id,null);

        db.close();
    }
    public void delete(int id)
    {
        db = openDB();
        db.delete("tblLichChich","ID =" + id,null);
        db.close();
    }


}
