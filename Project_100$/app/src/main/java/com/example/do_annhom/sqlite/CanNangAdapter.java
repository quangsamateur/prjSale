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

public class CanNangAdapter extends RecyclerView.Adapter<CanNangAdapter.CanNangVH> {
    ArrayList<CanNang> canNangs;
    Listener listener;

    public CanNangAdapter(  ArrayList<CanNang> canNangs,Listener listener) {
        this.canNangs = canNangs;
        this.listener = listener;
    }
    @NonNull
    @Override
    public CanNangAdapter.CanNangVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cannang_chieucao,parent,false);
        return new CanNangVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CanNangAdapter.CanNangVH holder, @SuppressLint("RecyclerView") int position) {
        CanNang canNang1 = canNangs.get(position);
        holder.tvchieucao.setText(String.valueOf(canNang1.getChieucao()));
        holder.tvgioitinh.setText(String.valueOf(canNang1.getGioitinh()));
        holder.tvcannang.setText(String.valueOf(canNang1.getCannang()));
        holder.tvBMI.setText(String.format("%.2f",canNang1.getBmi()));
        holder.tvTB1.setText(String.valueOf(canNang1.getTb1()));
        holder.tvTB2.setText(String.valueOf(canNang1.getTb2()));
        holder.tvNgay.setText(String.valueOf(canNang1.getNgaydo()));
        holder.tvGhiChu.setText(String.valueOf(canNang1.getGhichu()));
        holder.tvxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onDeleteListener(canNang1.getId());
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.setOnInfoClick(canNang1);
            }
        });
        holder.tvsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.setOnEditClick(position,canNang1);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (canNangs !=null)
        {
            return  canNangs.size();
        }
        return 0;
    }

    public class CanNangVH extends  RecyclerView.ViewHolder{
        TextView tvcannang,tvchieucao,tvNgay,tvBMI,tvTB1,tvTB2,tvGhiChu,tvsua,tvxoa,tvgioitinh;


        public CanNangVH(@NonNull View itemView) {
            super(itemView);
            tvcannang = itemView.findViewById(R.id.edit_canang);
            tvNgay = itemView.findViewById(R.id.ed_ngaydo);
            tvchieucao = itemView.findViewById(R.id.edit_chieucao);
            tvBMI = itemView.findViewById(R.id.edit_bmi);
            tvTB1 = itemView.findViewById(R.id.edit_thong_bao_1);
            tvTB2 = itemView.findViewById(R.id.edit_thong_bao_2);
            tvGhiChu = itemView.findViewById(R.id.edit_gichu);
            tvsua = itemView.findViewById(R.id.edit_sua);
            tvxoa = itemView.findViewById(R.id.edit_xoa);
            tvgioitinh=itemView.findViewById(R.id.edit_thong_bao_giotinh);
        }
    }
    public void addCanNang(CanNang canNang){
        canNangs.add(canNang);
        notifyDataSetChanged();
    }
    public void editCanNang(CanNang canNang,int pos){
        canNangs.set(pos, canNang);
        notifyDataSetChanged();
    }
    public void deleteCanNang(int pos){
        canNangs.remove(pos);
        notifyDataSetChanged();
    }
    public interface  Listener{
        void onItemListener(int position,CanNang canNang);
        void setOnInfoClick(CanNang canNang);
        void setOnEditClick(int pos, CanNang canNang);
        void onDeleteListener(int id);
    }


}