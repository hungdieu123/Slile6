package com.hungviet.slile6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DangKyAdapter extends BaseAdapter {
    List<KhoaHoc> khoaHocList;
    Context context;
    ListView lvList;

    public DangKyAdapter(List<KhoaHoc> khoaHocList, Context context, ListView lvList) {
        this.khoaHocList = khoaHocList;
        this.context = context;
        this.lvList=lvList;
    }

    @Override
    public int getCount() {
        return khoaHocList.size();
    }

    @Override
    public KhoaHoc getItem(int i) {
        return khoaHocList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder {

        ImageView imgLogo, btnDelete;
        TextView tvTen, tvGia;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        final KhoaHoc khoaHoc = (KhoaHoc) getItem(i);
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.row_thucdon, viewGroup, false);
            viewHolder.imgLogo = view.findViewById(R.id.imgLogo_thucdon);
            viewHolder.tvTen = view.findViewById(R.id.tvTen_thucdon);
            viewHolder.tvGia = view.findViewById(R.id.tvGia_thucdon);
            viewHolder.btnDelete = view.findViewById(R.id.btnDelete);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }


        viewHolder.tvTen.setText(khoaHoc.getTen());
        viewHolder.tvGia.setText(khoaHoc.getGia());
        viewHolder.imgLogo.setImageResource(khoaHoc.getAnh());


        viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MonanDAO monanDAO = new MonanDAO(context);
                monanDAO.deletema(khoaHoc.getTen());
                Toast.makeText(context, "Xoá thành công", Toast.LENGTH_SHORT).show();
                khoaHocList = monanDAO.getAll();
                lvList.setAdapter(DangKyAdapter.this);

            }
        });


        return view;
    }
}