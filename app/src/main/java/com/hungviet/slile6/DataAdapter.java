package com.hungviet.slile6;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class DataAdapter extends BaseAdapter {
    private Context context;
    private List<TinTuc> tinTucList;

    public DataAdapter(Context context, List<TinTuc> tinTucList) {
        this.context = context;
        this.tinTucList = tinTucList;
    }



    @Override
    public int getCount() {
        return tinTucList.size();
    }

    @Override
    public Object getItem(int position) {
        return tinTucList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.tintuc, parent, false);
        TextView tvData = view.findViewById(R.id.tvData);

        TinTuc tinTuc = tinTucList.get(position);
        tvData.setText(tinTuc.title);
//        tvDescription.setText(tinTuc.description);
//        tvLink.setText(tinTuc.linkk);




//        File file=new File(tinTuc.image);
//        if(file.exists()) {
//            Bitmap myBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
//
//            tvImage.setImageBitmap(myBitmap);
//
//
//        }


        tvData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TinTuc tinTuc = tinTucList.get(position);
                Intent intent = new Intent(context, WebviewActivity.class);
                intent.putExtra("title", tinTuc.title);
                intent.putExtra("link", tinTuc.linkk);
                context.startActivity(intent);

            }
        });

        return view;
    }




}
