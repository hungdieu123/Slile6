package com.hungviet.slile6;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class KhoaHocActivity extends AppCompatActivity {

    ListView listView;
    List<KhoaHoc> khoaHocList;
    KhoaHocAdapter khoaHocAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        listView = findViewById(R.id.lvList);


        khoaHocList = new ArrayList<>();

            KhoaHoc khoaHoc = new KhoaHoc();
            khoaHoc.setAnh(R.drawable.anh1);
            khoaHoc.setTen("Book: Giáo Trình Lập Trình Android");
            khoaHoc.setGia("Giá: 69 $");
            khoaHocList.add(khoaHoc);

        KhoaHoc khoaHoc1 = new KhoaHoc();
        khoaHoc1.setAnh(R.drawable.anh2);
        khoaHoc1.setTen("Book: Lập Trình Android");
        khoaHoc1.setGia("Giá: 29 $");
        khoaHocList.add(khoaHoc1);

        KhoaHoc khoaHoc2 = new KhoaHoc();
        khoaHoc2.setAnh(R.drawable.anh3);
        khoaHoc2.setTen("Book: Phát Triển Ứng Dụng");
        khoaHoc2.setGia("Giá: 36 $");
        khoaHocList.add(khoaHoc2);



        KhoaHoc khoaHoc4 = new KhoaHoc();
        khoaHoc4.setAnh(R.drawable.anh2);
        khoaHoc4.setTen("Book: Lập Trình Android");
        khoaHoc4.setGia("Giá: 300 $");
        khoaHocList.add(khoaHoc4);




        khoaHocAdapter = new KhoaHocAdapter(khoaHocList,this);
        listView.setAdapter(khoaHocAdapter);
    }
}
