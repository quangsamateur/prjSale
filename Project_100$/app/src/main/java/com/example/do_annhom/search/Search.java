package com.example.do_annhom.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.SearchView;

import android.widget.TextView;

//import com.example.do_annhom.Model.TintucAdapter;
//import com.example.do_annhom.Model.TintucModel;
import com.example.do_annhom.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Search extends AppCompatActivity {
    RecyclerView recyclerView;

//    TintucAdapter tintucAdapter;
//    TextView textViewserach;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search);
//        recyclerView=findViewById(R.id.recleset2_search);
//        Toolbar toolbar=findViewById(R.id.toolbar_search);
//
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        FirebaseRecyclerOptions<TintucModel> options = new
//                FirebaseRecyclerOptions.Builder<TintucModel>()
//                .setQuery(FirebaseDatabase.getInstance().getReference().child("Tintuc"),TintucModel.class)
//                .build();
//        tintucAdapter=new TintucAdapter(options);
//        recyclerView.setAdapter(tintucAdapter);



//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
//
//
//    }
//    @Override
//    public void onStart() {
//        super.onStart();
//        tintucAdapter.startListening();
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        tintucAdapter.stopListening();
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_nu,menu);
//        MenuItem item=menu.findItem(R.id.sreach);
//        SearchView searchView= (SearchView) item.getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String newText) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                String searchValue = newText;
//                if (!searchValue.isEmpty()) {
//                    // Chuyển đổi chữ cái đầu tiên sang chữ hoa
//                    searchValue = searchValue.substring(0, 1).toUpperCase() + searchValue.substring(1);
//                }
//
//                mysearch(searchValue);
//                return true;
//            }
//
//
//        });
//
//
//        return super.onCreateOptionsMenu(menu);
//    }
//    private void mysearch(String newText) {
//        FirebaseRecyclerOptions<TintucModel> options = new
//                FirebaseRecyclerOptions.Builder<TintucModel>()
//                .setQuery(FirebaseDatabase.getInstance().getReference().child("Tintuc").orderByChild("title").startAt(newText).endAt(newText+"\uf8ff"),TintucModel.class)
//                .build();
//
//        tintucAdapter=new TintucAdapter(options);
//        tintucAdapter.startListening();
//        recyclerView.setAdapter(tintucAdapter);
//    }

}