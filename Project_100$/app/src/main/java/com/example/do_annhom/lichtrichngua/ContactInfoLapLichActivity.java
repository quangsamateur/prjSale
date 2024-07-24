package com.example.do_annhom.lichtrichngua;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.do_annhom.R;
import com.example.do_annhom.sqlite.LichChich;

public class ContactInfoLapLichActivity extends AppCompatActivity {
    TextView tenmuitiem,tenvacxin,ngatiem,dotuoi,muiso,cosotiem,ghichu,gio;
    LichChich contact;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info_lap_lich);
        Intent intent = getIntent();

        contact = (LichChich) intent.getSerializableExtra("lichchich");
        tenmuitiem=findViewById(R.id.edit_muitiem);
        tenvacxin=findViewById(R.id.edit_vacxin);
        ngatiem=findViewById(R.id.edngaytiem);
        dotuoi=findViewById(R.id.edtuoi);
        muiso=findViewById(R.id.edmuiso);
        cosotiem=findViewById(R.id.edcosotiem);
        ghichu=findViewById(R.id.edghichu);
        gio=findViewById(R.id.edgiotiem);


        tenmuitiem.setText(contact.getTenmuitiem());
        tenvacxin.setText(contact.getTenvacxin());
        ngatiem.setText(contact.getNgaytiem());
        dotuoi.setText(contact.getTuoi());
        muiso.setText(contact.getMuiso());
        cosotiem.setText(contact.getCosoitem());
        ghichu.setText(contact.getGhichu());
        gio.setText(contact.getGiotiem());
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        intent=getIntent();

        if(intent!=null){
            contact= (LichChich) intent.getSerializableExtra("lichchich");
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}