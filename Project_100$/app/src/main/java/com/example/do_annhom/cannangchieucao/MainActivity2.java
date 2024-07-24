package com.example.do_annhom.cannangchieucao;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
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
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.do_annhom.R;
import com.example.do_annhom.sqlite.CanNang;
import com.example.do_annhom.sqlite.CanNangAdapter;
import com.example.do_annhom.sqlite.CanNangDB;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class MainActivity2 extends AppCompatActivity implements CanNangAdapter.Listener {

    RecyclerView rvContact;
    ArrayList<CanNang> canNangs;
    CanNangAdapter canNangAdapter;
    TextView fabAddContact;
    TextView gioith;
    CanNang canNang;
    CanNangDB canNangDB;

    int position;
    ImageView ivDelete;

    ActivityResultLauncher<Intent> mLaucher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        if (result.getData().getIntExtra("flag", 0) == 1) {
                            CanNang canNang1 = (CanNang) result.getData().getSerializableExtra("cannang");
                            canNangDB.insertCanNang(canNang1.getCannang(),canNang1.getChieucao(),canNang1.getGhichu(),canNang1.getNgaydo(),canNang1.getGioitinh(),
                                    canNang1.getDotuoi(),canNang1.getBmi(),canNang1.getTb1(),canNang1.getTb2());
                            canNangs.clear();
                            canNangs.addAll(canNangDB.getCanNangs());
                            Toast toast = Toast.makeText(getApplicationContext(), "Bạn thêm đã thành công", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP, 0, 0); // Đặt Toast trên cùng màn hình
                            toast.show();
                            canNangAdapter.notifyDataSetChanged();
                        }
                        if (result.getData().getIntExtra("flag", 0) == 2){
                            CanNang canNang1 = (CanNang) result.getData().getSerializableExtra("cannang");
                            canNangDB.updateCanNang(canNang1.getId(),canNang1.getCannang(),canNang1.getChieucao(),canNang1.getGhichu(),canNang1.getNgaydo(),canNang1.getGioitinh(),
                                    canNang1.getDotuoi(),canNang1.getBmi(),canNang1.getTb1(),canNang1.getTb2());
                            canNangs.clear();
                            canNangs.addAll(canNangDB.getCanNangs());
                            Toast toast = Toast.makeText(getApplicationContext(), "Bạn sửa đã thành công", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP, 0, 0); // Đặt Toast trên cùng màn hình
                            toast.show();
                            canNangAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }
    );


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rvContact = findViewById(R.id.rvContacts);


        canNangDB = new CanNangDB(MainActivity2.this);
        canNangs  = canNangDB.getCanNangs();

        canNangAdapter = new CanNangAdapter(canNangs,this);
        rvContact.setAdapter(canNangAdapter);
        rvContact.setLayoutManager(new LinearLayoutManager(MainActivity2.this, LinearLayoutManager.VERTICAL, false));
        rvContact.addItemDecoration(new DividerItemDecoration(MainActivity2.this, LinearLayoutManager.VERTICAL));


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
                Intent intent = new Intent(MainActivity2.this,AddEditActivity.class);
                intent.putExtra("flag",1);
                mLaucher.launch(intent);

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.mnuSort){
            Collections.sort(canNangs, dateComparator);
            canNangAdapter.notifyDataSetChanged();
        }

        return super.onOptionsItemSelected(item);
    }

    Comparator<CanNang> dateComparator = new Comparator<CanNang>() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        @Override
        public int compare(CanNang canNang1, CanNang canNang2) {
            Date date1 = null;
            Date date2 = null;
            try {
                date1 = dateFormat.parse(canNang1.getNgaydo());
                date2 = dateFormat.parse(canNang2.getNgaydo());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date1.compareTo(date2);
        }
    };
@Override
public void onItemListener(int pos,CanNang canNang) {

}

    @Override
public void setOnInfoClick(CanNang canNang) {
    position=canNang.getId();
    Intent intent = new Intent(MainActivity2.this, ContactInfoActivity.class);
    intent.putExtra("cannang",canNang);
    startActivity(intent);
}

    @Override
    public void setOnEditClick(int pos, CanNang canNang) {
        position =pos;
        Intent intent = new Intent(MainActivity2.this, AddEditActivity.class);
        intent.putExtra("flag",2);
        intent.putExtra("cannang", canNang);
        canNangAdapter.editCanNang(canNang,pos);
        mLaucher.launch(intent);
    }

    @Override
    public void onDeleteListener(int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
        builder.setMessage("Bạn muốn xóa này không?");
        builder.setPositiveButton("Có", (dialog, which) -> {
           canNangDB.delete(id);
           canNangs.clear();
           canNangs.addAll(canNangDB.getCanNangs());
           canNangAdapter.notifyDataSetChanged();
            dialog.dismiss();
        });
        builder.setNegativeButton("Không", (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();

    }

}