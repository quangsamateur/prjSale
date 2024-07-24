package com.example.do_annhom.lichtrichngua;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.do_annhom.R;
import com.example.do_annhom.sqlite.LichChich;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;
import java.util.Random;
public class AddEdit_LapLichActivity extends AppCompatActivity {

    TextInputLayout ticosotiem,titenvacxin,tighichu,tingaytiem,tigio;
    TextInputEditText edcosotiem,edtenvacxin,edghichu,edngaytiem,edgio;
    Spinner spdotuoi,spmuiso,sptenmuitiem;
    String thongbao="";
    LichChich lichChichEdit;
    TextView tenmuitiem,tuoi,muiso;
    int eYear, eMonth, eDay;
    int hour ;
    int minute;
    int flag;
    String text;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_lap_lich_tiem);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        tenmuitiem=findViewById(R.id.thu1);
        muiso=findViewById(R.id.thu2);
        tuoi=findViewById(R.id.thu3);
        tenmuitiem.setVisibility(View.GONE);
        muiso.setVisibility(View.GONE);
        tuoi.setVisibility(View.GONE);
        ticosotiem=findViewById(R.id.txiputlayout_cosotiem);
        titenvacxin=findViewById(R.id.tivacxin);
        tingaytiem=findViewById(R.id.tingaytiem);
        tighichu=findViewById(R.id.tighichu);
        tigio=findViewById(R.id.tigio);

        edcosotiem=findViewById(R.id.edit_cosotiem);
        edgio=findViewById(R.id.edgio);
        edtenvacxin=findViewById(R.id.edit_vacxin);
        edngaytiem=findViewById(R.id.edngaytiem);
        edghichu=findViewById(R.id.edghichu);
         spdotuoi=findViewById(R.id.spage);
         sptenmuitiem=findViewById(R.id.spmuitiem);
         spmuiso=findViewById(R.id.spmuiso);
//============================================


//
        spdotuoi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int selectedItemPosition = spdotuoi.getSelectedItemPosition();
                String selectedItemtuoi = spdotuoi.getItemAtPosition(selectedItemPosition).toString();
                tuoi.setText(selectedItemtuoi);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sptenmuitiem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int selectedItemPosition = sptenmuitiem.getSelectedItemPosition();
                String selectedItemtuoi = sptenmuitiem.getItemAtPosition(selectedItemPosition).toString();
                tenmuitiem.setText(selectedItemtuoi);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spmuiso.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int selectedItemPosition = spmuiso.getSelectedItemPosition();
                String selectedItemtuoi = spmuiso.getItemAtPosition(selectedItemPosition).toString();
                muiso.setText(selectedItemtuoi);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Intent intent = getIntent();
        flag = intent.getIntExtra("flag", 0);
        if (flag == 1) {
            toolbar.setTitle("Thêm mới");
        } else {
            toolbar.setTitle("Sửa lại ");
            lichChichEdit = (LichChich) intent.getSerializableExtra("lichchich");
            edcosotiem.setText(String.valueOf(lichChichEdit.getCosoitem()));
            edtenvacxin.setText(String.valueOf(lichChichEdit.getTenvacxin()));
            edghichu.setText(lichChichEdit.getGhichu());
            edngaytiem.setText(lichChichEdit.getNgaytiem());
            edgio.setText(lichChichEdit.getGiotiem());
        }


        edngaytiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                eYear = calendar.get(Calendar.YEAR);
                eMonth = calendar.get(Calendar.MONTH);
                eDay = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddEdit_LapLichActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        edngaytiem.setText(dayOfMonth + "/" + String.format("%02d", month + 1) + "/" + year);
                    }
                }, eYear, eMonth, eDay);
                datePickerDialog.show();
            }
        });
        edgio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                hour = calendar.get(Calendar.HOUR_OF_DAY);
                minute = calendar.get(Calendar.MINUTE);

                // Tạo đối tượng TimePickerDialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(AddEdit_LapLichActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minuteOfHour) {
                                // Lưu giá trị giờ và phút được chọn
                                hour = hourOfDay;
                                minute = minuteOfHour;

                                // Hiển thị giá trị giờ và phút được chọn
                                String time = String.format("%02d:%02d", hour, minute);
                                edgio.setText(time);
                            }
                        }, hour, minute, true);

                // Hiển thị dialog chọn giờ
                timePickerDialog.show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_save, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnuSave) {
            if (edcosotiem.getText().toString().isEmpty()
                    || edngaytiem.getText().toString().isEmpty()
                    || edghichu.getText().toString().isEmpty()
                    || edtenvacxin.getText().toString().isEmpty()||edgio.getText().toString().isEmpty()) {
                titenvacxin.setError("Đừng để trống");
                tingaytiem.setError("Đừng để trống");
                tighichu.setError("Đừng để trống");
                ticosotiem.setError("Đừng để trống");
                tigio.setError("Đừng để trống");
                return false;
            } else {
                if (flag == 1) {
                    Random rnd = new Random();
                    int number = rnd.nextInt(9999);
                    LichChich lichChich = new LichChich(number,
                            tenmuitiem.getText().toString(),
                            edtenvacxin.getText().toString(),
                            edngaytiem.getText().toString(),
                            tuoi.getText().toString(),
                            muiso.getText().toString(),
                            edcosotiem.getText().toString(),
                            edghichu.getText().toString(),
                            edgio.getText().toString());

                    Intent intent = new Intent();
                    intent.putExtra("lichchich", lichChich);
                    intent.putExtra("flag", 1);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {

                    LichChich lichChich = new LichChich(lichChichEdit.getId(),
                            tenmuitiem.getText().toString(),
                            edtenvacxin.getText().toString(),
                            edngaytiem.getText().toString(),
                            tuoi.getText().toString(),
                            muiso.getText().toString(),
                            edcosotiem.getText().toString(),
                            edghichu.getText().toString(),edgio.getText().toString());
                    Intent intent = new Intent();
                    intent.putExtra("lichchich", lichChich);
                    intent.putExtra("flag", 2);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }



}
