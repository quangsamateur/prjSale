package com.example.do_annhom.CamNang;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.do_annhom.Model.CamNangAdapter;
import com.example.do_annhom.Model.CamNangModel;
import com.example.do_annhom.R;
import com.example.do_annhom.search.Search;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class PhatTrienActivity extends AppCompatActivity implements CamNangAdapter.Listener {

    Context mcontext;
    ArrayList<CamNangModel> tintucs;
    RecyclerView mrecyclerView;
    CamNangAdapter tinAdapter;
    FragmentManager fragmentManager;
    FloatingActionButton floatingActionButton;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_phattrien);

        mcontext = this;
        mrecyclerView = findViewById(R.id.recleset1);
        floatingActionButton = findViewById(R.id.floatingActionButton1);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhatTrienActivity.this, Search.class);
                startActivity(intent);
            }
        });
        db = FirebaseFirestore.getInstance();
        mrecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        tintucs = new ArrayList<>();
        tinAdapter = new CamNangAdapter(tintucs, this);
        db.collection("TinTucFull").document("tintuc").collection("CotMocPhatTrien")

                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                            String title = documentSnapshot.get("title").toString();
                            String imgurl = documentSnapshot.get("imgurl").toString();
                            String desin = documentSnapshot.get("desin").toString();
                            CamNangModel tintuc = new CamNangModel(title, imgurl, desin);
                            tintucs.add(tintuc);
                        }
                        tinAdapter.notifyDataSetChanged();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(mcontext, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        mrecyclerView.setAdapter(tinAdapter);
    }

    @Override
    public void setOnInfoClick(CamNangModel canNang) {

    }

    @Override
    public void setOnEditClick(int pos, CamNangModel canNang) {

    }

    @Override
    public void onDeleteListener(CamNangModel canNang) {

    }
}
