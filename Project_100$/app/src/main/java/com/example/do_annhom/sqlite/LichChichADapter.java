package com.example.do_annhom.sqlite;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.do_annhom.R;

import java.util.ArrayList;

public class LichChichADapter extends RecyclerView.Adapter<LichChichADapter.LichChichVH> {
    ArrayList<LichChich> lichChiches;
    Listener listener;

    public LichChichADapter(  ArrayList<LichChich> lichChiches,Listener listener) {
        this.lichChiches = lichChiches;
        this.listener = listener;
    }
    @NonNull
    @Override
    public LichChichADapter.LichChichVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_laplichtiem,parent,false);
        return new LichChichVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LichChichADapter.LichChichVH holder, @SuppressLint("RecyclerView") int position) {
        LichChich lichchich1 = lichChiches.get(position);
        holder.tentiem.setText(lichchich1.getTuoi());
        holder.tvmuiso.setText(lichchich1.getMuiso());
        holder.tvmuitiem.setText(lichchich1.getTenmuitiem());
        holder.edit_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onDeleteListener(lichchich1.getId());

            }
        });


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.setOnInfoClick(lichchich1);
            }
        });
        holder.edit_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.setOnEditClick(position,lichchich1);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (lichChiches !=null)
        {
            return  lichChiches.size();
        }
        return 0;
    }

    public class LichChichVH extends  RecyclerView.ViewHolder{
        TextView edit_sua,tentiem,edit_xoa,tvmuitiem,tvmuiso;


        public LichChichVH(@NonNull View itemView) {
            super(itemView);
            edit_sua = itemView.findViewById(R.id.edit_sua);
            tentiem = itemView.findViewById(R.id.tentiem);
            edit_xoa = itemView.findViewById(R.id.edit_xoa);
            tvmuitiem = itemView.findViewById(R.id.tvmuitiem);
            tvmuiso = itemView.findViewById(R.id.tvmuiso);
        }
    }
    public void addLichChich(LichChich lichChich){
        lichChiches.add(lichChich);
        notifyDataSetChanged();
    }
    public void editLichChich(LichChich lichChich,int pos){
        lichChiches.set(pos, lichChich);
        notifyDataSetChanged();
    }
    public void deleteLichChich(int pos){
        lichChiches.remove(pos);
        notifyDataSetChanged();
    }
    public interface  Listener{
        void onItemListener(int position,LichChich lichChich);
        void setOnInfoClick(LichChich lichChich);
        void setOnEditClick(int pos, LichChich lichChich);
        void onDeleteListener(int id);
    }


}
