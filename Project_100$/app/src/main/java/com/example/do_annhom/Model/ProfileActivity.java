package com.example.do_annhom.Model;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;


import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.do_annhom.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        bundle = getIntent().getExtras();
        if (bundle != null) {
            String title = bundle.getString("title");
            String description = bundle.getString("desin");
            String newsurl = bundle.getString("newsurl");

            ImageView imageView = findViewById(R.id.img);
            TextView titleTextView = findViewById(R.id.tiel);
            TextView descriptionTextView = findViewById(R.id.des);

            Glide.with(this)
                    .load(newsurl)
                    .error(R.drawable.anh_nen)
                    .into(imageView);
            titleTextView.setText(title);
            descriptionTextView.setText(description);
        }

    }


}