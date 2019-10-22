package com.hungviet.slile6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class KhoaHocAdapter extends BaseAdapter {

    List<KhoaHoc> khoaHocList;
    Context context;

    public KhoaHocAdapter(List<KhoaHoc> khoaHocList, Context context) {
        this.khoaHocList = khoaHocList;
        this.context = context;
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

    class ViewHolder {

        ImageView imgLogo, btnAdd;
        TextView tvTen, tvGia;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        final KhoaHoc khoaHoc = (KhoaHoc) getItem(i);
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.row_menu, viewGroup, false);
            viewHolder.imgLogo = view.findViewById(R.id.imgLogo_menu);
            viewHolder.tvTen = view.findViewById(R.id.tvTen_menu);
            viewHolder.tvGia = view.findViewById(R.id.tvGia_menu);
            viewHolder.btnAdd = view.findViewById(R.id.btnAdd);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }


        viewHolder.tvTen.setText(khoaHoc.getTen());
        viewHolder.tvGia.setText(khoaHoc.getGia());
        viewHolder.imgLogo.setImageResource(khoaHoc.getAnh());


        viewHolder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MonanDAO monanDAO = new MonanDAO(context);
                long result = monanDAO.insertma(khoaHoc);
                if (result > 0) {
                    Toast.makeText(context, "Thêm thành công khóa học "+"'" +khoaHoc.ten+"'", Toast.LENGTH_SHORT).show();

                    notifyDataSetChanged();
                } else {
                    Toast.makeText(context, "Đã đăng ký khóa học "+"'"+khoaHoc.ten+"'", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }
}
