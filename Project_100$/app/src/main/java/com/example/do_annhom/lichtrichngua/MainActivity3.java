package com.example.do_annhom.lichtrichngua;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.do_annhom.R;
import com.example.do_annhom.sqlite.LichChich;
import com.example.do_annhom.sqlite.LichChichADapter;
import com.example.do_annhom.sqlite.LichChichDB;


import java.util.ArrayList;


public class MainActivity3 extends AppCompatActivity implements LichChichADapter.Listener{
    RecyclerView rvContact;
    ArrayList<LichChich> lichChiches;
    LichChichADapter lichChichADapter;
    LichChichDB lichChichDB;
    TextView fabAddContact;
    LichChich lichChich;
    int position;

    ActivityResultLauncher<Intent> mLaucher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        if (result.getData().getIntExtra("flag", 0) == 1) {
                            LichChich lichChich = (LichChich) result.getData().getSerializableExtra("lichchich");
                            lichChichDB.insertLichChich(lichChich.getTenmuitiem(),lichChich.getTenvacxin(),lichChich.getNgaytiem(),lichChich.getTuoi(),lichChich.getMuiso(),
                                    lichChich.getCosoitem(),lichChich.getGhichu(),lichChich.getGiotiem());
                            lichChiches.clear();
                            lichChiches.addAll(lichChichDB.getLichChiches());
                            Toast toast = Toast.makeText(getApplicationContext(), "Bạn thêm đã thành công", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP, 0, 0); // Đặt Toast trên cùng màn hình
                            toast.show();
                            lichChichADapter.notifyDataSetChanged();
                        }
                        if (result.getData().getIntExtra("flag", 0) == 2){
                            LichChich lichChich = (LichChich) result.getData().getSerializableExtra("lichchich");
                            lichChichDB.updateLichChich(lichChich.getId(),lichChich.getTenmuitiem(),lichChich.getTenvacxin(),lichChich.getNgaytiem(),lichChich.getTuoi(),lichChich.getMuiso(),
                                    lichChich.getCosoitem(),lichChich.getGhichu(),lichChich.getGiotiem());
                            lichChiches.clear();
                            lichChiches.addAll(lichChichDB.getLichChiches());
                            Toast toast = Toast.makeText(getApplicationContext(), "Bạn sửa đã thành công", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP, 0, 0); // Đặt Toast trên cùng màn hình
                            toast.show();
                            lichChichADapter.notifyDataSetChanged();
                        }
                    }
                }
            }
    );

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3);
        rvContact = findViewById(R.id.rvContacts);
        lichChichDB = new LichChichDB(MainActivity3.this);
        lichChiches  = lichChichDB.getLichChiches();

        lichChichADapter = new LichChichADapter(lichChiches,this);
        rvContact.setAdapter(lichChichADapter);
        rvContact.setLayoutManager(new LinearLayoutManager(MainActivity3.this, LinearLayoutManager.VERTICAL, false));
        rvContact.addItemDecoration(new DividerItemDecoration(MainActivity3.this, LinearLayoutManager.VERTICAL));


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        fabAddContact = findViewById(R.id.fabAddContact);
        fabAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this,AddEdit_LapLichActivity.class);
                intent.putExtra("flag",1);
                mLaucher.launch(intent);

            }
        });

    }


    @Override
    public void onItemListener(int pos,LichChich lichChich) {

    }

    @Override
    public void setOnInfoClick(LichChich lichChich) {
        position=lichChich.getId();
        Intent intent = new Intent(MainActivity3.this,ContactInfoLapLichActivity.class);
        intent.putExtra("lichchich",lichChich);
        startActivity(intent);
    }

    @Override
    public void setOnEditClick(int pos, LichChich lichChich) {
        position =pos;
        Intent intent = new Intent(MainActivity3.this, AddEdit_LapLichActivity.class);
        intent.putExtra("flag",2);
        intent.putExtra("lichchich", lichChich);
        lichChichADapter.editLichChich(lichChich,pos);
        mLaucher.launch(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onDeleteListener(int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
        builder.setMessage("Bạn muốn xóa này không?");
        builder.setPositiveButton("Có", (dialog, which) -> {
            lichChichDB.delete(id);
            lichChiches.clear();
            lichChiches.addAll(lichChichDB.getLichChiches());
            lichChichADapter.notifyDataSetChanged();
            dialog.dismiss();

        });
        builder.setNegativeButton("Không", (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}