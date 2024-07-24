package com.example.do_annhom.Model;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.do_annhom.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CamNangAdapter  extends RecyclerView.Adapter<CamNangAdapter.myViewHolder> {
    ArrayList<CamNangModel> tintucs;
    Listener listener;


    public CamNangAdapter (ArrayList<CamNangModel> tintucs, Listener listener )
    {
        this.tintucs = tintucs;
        this.listener = listener;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tintuc,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        CamNangModel model1 = tintucs.get(position);

        holder.title.setText(model1.getTitle());
//        holder.desc.setText(model1.getDescription());
        Glide.with(holder.img.getContext())
                .load(model1.getImgurl())
//                .placeholder(com.google.firebase.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ProfileActivity.class);
                intent.putExtra("title", model1.getTitle());
//                intent.putExtra("description", model1.getDescription());
                intent.putExtra("imgurl", model1.getImgurl());
                intent.putExtra("desin",model1.getDesin());
                view.getContext().startActivity(intent);
            }
        });
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), ProfileActivity.class);
                intent.putExtra("title", model1.getTitle());
//                intent.putExtra("description", model1.getDescription());
                intent.putExtra("imgurl", model1.getImgurl());
                intent.putExtra("desin",model1.getDesin());
                view.getContext().startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        if (tintucs !=null)
        {
            return  tintucs.size();
        }
        return 0;
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        CircleImageView img,img_heart;
        TextView title,desc;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img =  itemView.findViewById(R.id.img_noi_bat);
            title = itemView.findViewById(R.id.title_noi_bat);
//            desc = itemView.findViewById(R.id.desc_noi_bat);

        }


    }
    public interface  Listener{
        void setOnInfoClick(CamNangModel canNang);
        void setOnEditClick(int pos, CamNangModel canNang);
        void onDeleteListener(CamNangModel canNang);
    }
}

