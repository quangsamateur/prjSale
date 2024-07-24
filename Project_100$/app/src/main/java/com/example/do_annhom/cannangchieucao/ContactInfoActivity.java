package com.example.do_annhom.cannangchieucao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.do_annhom.R;
import com.example.do_annhom.sqlite.CanNang;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class ContactInfoActivity extends AppCompatActivity {


    TextView txtCannang , txtChieucao, txtGhiChu,txtngaydo,txtgioitinh,txdotuoi;
    TextView ivContactLast;

   CanNang canNang;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);


        Intent intent = getIntent();

        canNang = (CanNang) intent.getSerializableExtra("cannang");

       txtCannang=findViewById(R.id.edit_canang);
       txtChieucao=findViewById(R.id.edit_chieucao);
       txtGhiChu=findViewById(R.id.edghichu);
       txtngaydo=findViewById(R.id.edngaydo);
      txtgioitinh=findViewById(R.id.edgioitinh);
      txdotuoi=findViewById(R.id.edtuoi);

//

        if (txtCannang != null) {
            txtCannang.setText(String.valueOf(canNang.getCannang()));
        }

        txtChieucao.setText(String.valueOf(canNang.getChieucao()));
        txtngaydo.setText(canNang.getNgaydo());
        txtGhiChu.setText(canNang.getGhichu());
       txtgioitinh.setText(canNang.getGioitinh());
       txdotuoi.setText(canNang.getDotuoi());


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}