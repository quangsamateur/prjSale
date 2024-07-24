package com.example.do_annhom.cannangchieucao;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.do_annhom.R;
import com.example.do_annhom.sqlite.CanNang;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;
import java.util.Random;
public class AddEditActivity extends AppCompatActivity {

    TextInputLayout ticannang, tichieucao, tighichu, tingaycando,tibmi,tigioitinh;
    TextInputEditText edcannang, edchieucao, edghichu, ednagycando,edgioitinh;
Spinner age;

    String thongbao="";
    TextView edbmi,gioitinh,thongbao1,thongbao2,edngay_vb;
    CanNang contactEdit;
    int eYear, eMonth, eDay;
    int flag;
String text;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

         Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
         ticannang=findViewById(R.id.txiputlayout_cannang);
          tichieucao=findViewById(R.id.tiChieucao);
         tighichu=findViewById(R.id.tighichu);
         tingaycando=findViewById(R.id.tingaydo);
         tibmi=findViewById(R.id.ed_bmi);
         age=findViewById(R.id.spage);
//
       edcannang=findViewById(R.id.edit_canang);
       edchieucao=findViewById(R.id.edit_chieucao);
       edghichu=findViewById(R.id.edghichu);
       ednagycando=findViewById(R.id.edngaydo);
        edbmi=findViewById(R.id.edbmi);
        gioitinh=findViewById(R.id.edtgioitinh);
        thongbao1=findViewById(R.id.edtthongbao1);
        thongbao2=findViewById(R.id.edtthongbao2);
        edngay_vb=findViewById(R.id.edngaydo_tuoi);

        tibmi.setVisibility(View.GONE);
        edbmi.setVisibility(View.GONE);
        gioitinh.setVisibility(View.GONE);
        thongbao1.setVisibility(View.GONE);
        thongbao2.setVisibility(View.GONE);
        edngay_vb.setVisibility(View.GONE);

//gioi tinh
        RadioGroup gioiTinhRadioGroup = findViewById(R.id.rgPercentage);
        gioiTinhRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                double chieucao= Double.parseDouble(edchieucao.getText().toString());
                double cannang=Double.parseDouble(edcannang.getText().toString());
                double tinhcc=chieucao/100;
                double tinh=cannang/(tinhcc*tinhcc);

                edbmi.setText(String.valueOf(tinh));
                RadioButton radioButton = group.findViewById(checkedId);
                String gioiTinh = radioButton.getText().toString();
                if(gioiTinh.equals("Con gái")) {
                   if(tinh>=30){
                       thongbao1.setText("béo phì");
                   }
                   else if(tinh>=25&&tinh<=29.9){
                       thongbao1.setText("thừa cân");
                   } else if (tinh>=18.5&&tinh<=24.9) {
                       thongbao1.setText("bình thường");
                   } else if (tinh<18.5) {
                       thongbao1.setText("nhẹ cân");
                   }
                    //////////////////
                    age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                            int selectedItemPosition = age.getSelectedItemPosition();
                            String selectedItem = age.getItemAtPosition(selectedItemPosition).toString();
                            if (selectedItem.equals("sơ sinh")) {
                                if(cannang<=2.4&&chieucao<=45.4){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>2.4&& cannang<4.2&&chieucao>45.4&&chieucao<52.9) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=4.2&&chieucao>=52.9) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("1 tháng")) {
                                if(cannang<=3.2&&chieucao<=49.8){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>3.2&& cannang<5.5&&chieucao>49.8&&chieucao<57.6) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=5.5&&chieucao>=57.6) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("2 tháng")) {
                                if(cannang<=3.9&&chieucao<=53){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>3.9&& cannang<6.6&&chieucao>53&&chieucao<61.1) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=6.6&&chieucao>=61.1) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("3 tháng")) {
                                if(cannang<=4.5&&chieucao<=55.6){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>4.5&& cannang<7.5&&chieucao>55.6&&chieucao<64) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=7.5&&chieucao>=64) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("4 tháng")) {
                                if(cannang<=5&&chieucao<=57.8){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>5&& cannang<8.2&&chieucao>57.8&&chieucao<66.4) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=8.2&&chieucao>=66.4) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("5 tháng")) {
                                if(cannang<=5.4&&chieucao<=59.6){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>5.4&& cannang<8.8&&chieucao>59.6&&chieucao<68.5) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=8.8&&chieucao>=68.5) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("6 tháng")) {
                                if(cannang<=5.7&&chieucao<=61.2){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>5.7&& cannang<9.3&&chieucao>61.2&&chieucao<70.3) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=9.3&&chieucao>=70.3) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("7 tháng")) {
                                if(cannang<=6&&chieucao<=62.7){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>6&& cannang<9.8&&chieucao>62.7&&chieucao<71.9) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=9.8&&chieucao>=71.9) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("8 tháng")) {
                                if(cannang<=6.3&&chieucao<=64){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>6.3&& cannang<10.2&&chieucao>64&&chieucao<73.5) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=10.2&&chieucao>=73.5) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("9 tháng")) {
                                if(cannang<=6.5&&chieucao<=65.3){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>6.5&& cannang<10.5&&chieucao>65.3&&chieucao<75) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=10.5&&chieucao>=75) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }

                            }
                            else if (selectedItem.equals("10 tháng")) {
                                if(cannang<=6.7&&chieucao<=66.5){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>6.7&& cannang<10.9&&chieucao>66.5&&chieucao<76.4) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=10.9&&chieucao>=76.4) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }

                            else if (selectedItem.equals("11 tháng")) {
                                if(cannang<=6.9&&chieucao<=67.7){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>6.9&& cannang<11.2&&chieucao>67.7&&chieucao<77.8) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=11.2&&chieucao>=77.8) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("12 tháng")) {
                                if(cannang<=7&&chieucao<=68.9){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>7&& cannang<11.5&&chieucao>68.9&&chieucao<79.2) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=11.5&&chieucao>=79.2) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("15 tháng")) {
                                if(cannang<=7.6&&chieucao<=72){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>7.6&& cannang<12.4&&chieucao>72&&chieucao<83) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=12.4&&chieucao>=83) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("18 tháng")) {
                                if(cannang<=8.1&&chieucao<=74.9){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>8.1&& cannang<13.2&&chieucao>74.9&&chieucao<86.5) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=13.2&&chieucao>=86.5) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("21 tháng")) {
                                if(cannang<=8.6&&chieucao<=77.5){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>8.6&& cannang<14&&chieucao>77.5&&chieucao<89.8) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=14&&chieucao>=89.8) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("2 tuổi")) {
                                if(cannang<=9&&chieucao<=80){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>9&& cannang<14.8&&chieucao>80&&chieucao<92.9) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=14.8&&chieucao>=92.9) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("2,5 tuổi")) {
                                if(cannang<=10&&chieucao<=83.6){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>10&& cannang<16.5&&chieucao>83.6&&chieucao<97.7) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=16.5&&chieucao>=97.7) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("3 tuổi")) {
                                if(cannang<=10.8&&chieucao<=87.4){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>10&& cannang<18.1&&chieucao>87.4&&chieucao<102.7) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=18.1&&chieucao>=102.7) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }


                            thongbao2.setText(thongbao);
                            edngay_vb.setText(selectedItem);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }

                //nam
                else {
                    if(tinh>=30){
                        thongbao1.setText("béo phì");
                    }
                    else if(tinh>=25&&tinh<=29.9){
                        thongbao1.setText("thừa cân");
                    } else if (tinh>=18.5&&tinh<=24.9) {
                        thongbao1.setText("bình thường");
                    } else if (tinh<18.5) {
                        thongbao1.setText("nhẹ cân");
                    }
                    age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                            String selectedItem = parent.getItemAtPosition(pos).toString();

                            if (selectedItem.equals("sơ sinh")) {
                                if(cannang<=2.5&&chieucao<=46.1){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>2.5&& cannang<4.4&&chieucao>46.1&&chieucao<53.7) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=4.4&&chieucao>=53.7) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("1 tháng")) {
                                if(cannang<=3.4&&chieucao<=50.8){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>3.4&& cannang<5.8&&chieucao>50.8&&chieucao<58.6) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=5.8&&chieucao>=58.6) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("2 tháng")) {
                                if(cannang<=4.3&&chieucao<=54.4){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>4.3&& cannang<7.1&&chieucao>54.4&&chieucao<62.4) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=7.1&&chieucao>=62.4) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("3 tháng")) {
                                if(cannang<=5&&chieucao<=57.3){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>5&& cannang<8&&chieucao>57.3&&chieucao<65.5) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=8&&chieucao>=65.5) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("4 tháng")) {
                                if(cannang<=5.6&&chieucao<=59.7){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>5.6&& cannang<8.7&&chieucao>59.7&&chieucao<68) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=8.7&&chieucao>=68) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("5 tháng")) {
                                if(cannang<=6&&chieucao<=61.7){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>6&& cannang<9.3&&chieucao>61.7&&chieucao<70.1) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=9.3&&chieucao>=70.1) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("6 tháng")) {
                                if(cannang<=6.4&&chieucao<=63.3){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>6.4&& cannang<9.8&&chieucao>63.3&&chieucao<71.9) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=9.8&&chieucao>=71.9) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("7 tháng")) {
                                if(cannang<=6.7&&chieucao<=64.8){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>6.7&& cannang<10.3&&chieucao>64.8&&chieucao<73.5) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=10.3&&chieucao>=73.5) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("8 tháng")) {
                                if(cannang<=6.9&&chieucao<=66.2){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>6.9&& cannang<10.7&&chieucao>66.2&&chieucao<75) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=10.7&&chieucao>=75) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("9 tháng")) {
                                if(cannang<=7.1&&chieucao<=67.5){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>7.1&& cannang<11&&chieucao>67.5&&chieucao<76.5) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=10.5&&chieucao>=76.5) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("10 tháng")) {
                                if(cannang<=7.4&&chieucao<=68.7){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>7.4&& cannang<11.4&&chieucao>68.7&&chieucao<77.9) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=11.4&&chieucao>=77.9) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }

                            else if (selectedItem.equals("11 tháng")) {
                                if(cannang<=7.6&&chieucao<=69.9){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>7.6&& cannang<11.7&&chieucao>69.9&&chieucao<79.2) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=11.7&&chieucao>=79.2) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("12 tháng")) {
                                if(cannang<=7.7&&chieucao<=71){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>7.7&& cannang<12&&chieucao>71&&chieucao<80.5) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=12&&chieucao>=80.5) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("15 tháng")) {
                                if(cannang<=8.3&&chieucao<=74.1){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>8.3&& cannang<12.8&&chieucao>74.1&&chieucao<84.2) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=12.8&&chieucao>=84.2) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }

                            else if (selectedItem.equals("18 tháng")) {
                                if(cannang<=8.8&&chieucao<=76.9){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>8.8&& cannang<13.7&&chieucao>76.9&&chieucao<87.7) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=13.7&&chieucao>=87.7) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("21 tháng")) {
                                if(cannang<=9.2&&chieucao<=79.4){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>9.2&& cannang<14.5&&chieucao>79.4&&chieucao<90.9) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=14.5&&chieucao>=90.9) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("2 tuổi")) {
                                if(cannang<=9.7&&chieucao<=81){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>9.7&& cannang<15.3&&chieucao>81&&chieucao<93.2) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=15.3&&chieucao>=93.2) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("2,5 tuổi")) {
                                if(cannang<=10.5&&chieucao<=85.1){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>10.5&& cannang<16.9&&chieucao>85.1&&chieucao<98.7) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=16.9&&chieucao>=98.7) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }
                            else if (selectedItem.equals("3 tuổi")) {
                                if(cannang<=11.3&&chieucao<=88.7){
                                    thongbao="Bé đang trong tình trạng suy dinh dưỡng thể thiếu cân hoặc thấp còi.";
                                } else if (cannang>11.3&& cannang<18.3&&chieucao>87.4&&chieucao<103.5) {
                                    thongbao="Bé có thể đạt chuẩn trung bình";
                                } else if (cannang>=18.3&&chieucao>=103.5) {
                                    thongbao="Bé đang thừ cân béo phì(theo cân nặng) hoặc rất cao(theo chiều cao)";
                                }
                            }

                            thongbao2.setText(thongbao);
                            edngay_vb.setText(selectedItem);
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
                gioitinh.setText(gioiTinh);
            }
        });
//

//
        Intent intent = getIntent();
        flag = intent.getIntExtra("flag", 0);
        if (flag == 1) {
            toolbar.setTitle("Thêm mới");
        } else {
            toolbar.setTitle("Sửa lại ");
            contactEdit = (CanNang) intent.getSerializableExtra("cannang");
            edcannang.setText(String.valueOf(contactEdit.getCannang()));
            edchieucao.setText(String.valueOf(contactEdit.getChieucao()));
            edghichu.setText(contactEdit.getGhichu());
            ednagycando.setText(contactEdit.getNgaydo());
            edbmi.setText(String.valueOf(contactEdit.getBmi()));
            gioitinh.setText(contactEdit.getGioitinh());
            thongbao1.setText(contactEdit.getTb1());
            thongbao2.setText(contactEdit.getTb2());
            edngay_vb.setText(contactEdit.getNgaydo());
        }
//

//
        ednagycando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                eYear = calendar.get(Calendar.YEAR);
                eMonth = calendar.get(Calendar.MONTH);
                eDay = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddEditActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        ednagycando.setText(dayOfMonth + "/" + String.format("%02d", month + 1) + "/" + year);
                    }
                }, eYear, eMonth, eDay);
                datePickerDialog.show();
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
            if (edcannang.getText().toString().isEmpty()
                    || edchieucao.getText().toString().isEmpty()
                    || edghichu.getText().toString().isEmpty()
                    || ednagycando.getText().toString().isEmpty()) {
                ticannang.setError("Đừng để trống");
                tichieucao.setError("Đừng để trống");
                tighichu.setError("Đừng để trống");
                tingaycando.setError("Đừng để trống");
                return false;
            } else {
                if (flag == 1) {
                    Random rnd = new Random();
                    int number = rnd.nextInt(9999);

                    CanNang canNang = new CanNang(number,
                            Integer.parseInt(edcannang.getText().toString()),
                            Integer.parseInt(edchieucao.getText().toString()),
                            edghichu.getText().toString(),
                            ednagycando.getText().toString(),
                            gioitinh.getText().toString()
                            ,edngay_vb.getText().toString()
                            ,Double.parseDouble( edbmi.getText().toString())
                            ,thongbao1.getText().toString(),
                            thongbao2.getText().toString());
                    Intent intent = new Intent();
                    intent.putExtra("cannang", canNang);
                    intent.putExtra("flag", 1);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {

                    CanNang canNang = new CanNang(contactEdit.getId(),
                            Integer.parseInt(edcannang.getText().toString()),
                            Integer.parseInt(edchieucao.getText().toString()),
                            edghichu.getText().toString(),
                            ednagycando.getText().toString(),
                            gioitinh.getText().toString()
                            ,edngay_vb.getText().toString()
                            ,Double.parseDouble( edbmi.getText().toString())
                            ,thongbao1.getText().toString(),
                            thongbao2.getText().toString());
                    Intent intent = new Intent();
                    intent.putExtra("cannang", canNang);
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
