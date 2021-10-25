package com.example.lamthuasm_duanmau.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lamthuasm_duanmau.Model.ThanhVien;
import com.example.lamthuasm_duanmau.R;
import com.example.lamthuasm_duanmau.Activity.ThanhVienActivity;

import java.util.List;

public class ThanhVienAdapter extends BaseAdapter {
    ThanhVienActivity context;
    List<ThanhVien> thanhVienList;

    public ThanhVienAdapter(ThanhVienActivity context, List<ThanhVien> thanhVienList) {
        this.context = context;
        this.thanhVienList = thanhVienList;
    }

    @Override
    public int getCount() {
        return thanhVienList.size();
    }

    @Override
    public Object getItem(int position) {
        return thanhVienList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view=convertView;
        if (convertView==null){
            view=View.inflate(viewGroup.getContext(), R.layout.layout_thanhvien,null);

        }
        ThanhVien thanhVien= (ThanhVien) getItem(position);
        TextView txtMaTV=view.findViewById(R.id.txtmaTV);
        TextView txthoTen=view.findViewById(R.id.txthoTen);
        TextView txtnamSinh=view.findViewById(R.id.txtnamSinh);


        ImageView imgDelete=(ImageView) view.findViewById(R.id.imgXoaThanhVien);

        txtMaTV.setText("Mã TV :"+thanhVien.getMaTV());
        txthoTen.setText("Tên TK :"+thanhVien.getHoTen());
        txtnamSinh.setText("Năm sinh :"+thanhVien.getNamSinh());


        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DiaLogXoaThanhVien(thanhVien.getHoTen());
            }
        });

        return view;
    }
}
