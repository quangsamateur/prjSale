package com.example.do_annhom.sqlite;

import android.app.Application;

public class App extends Application {

    LichChichDB lichChichDB;
    CanNangDB canNangDB;
    @Override
    public void onCreate() {
        super.onCreate();
        lichChichDB = new LichChichDB(this);
        lichChichDB.createTable();
        canNangDB = new CanNangDB(this);
        canNangDB.createTable();

        if(lichChichDB.countLichChiches() == 0){
            lichChichDB.insertLichChich("nho","das","123","","","",""
            ,"");

        }
        if(canNangDB.countCanNangs() == 0){
            canNangDB.insertCanNang(30,110,"123","","","",(30/1.21)
                    ,"","");

        }
    }

}
