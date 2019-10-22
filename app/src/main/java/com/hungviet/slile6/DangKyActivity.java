package com.hungviet.slile6;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class DangKyActivity extends AppCompatActivity {

    ListView listView;
    List<KhoaHoc> khoaHocList;
    DangKyAdapter dangKyAdapter;
    MonanDAO monanDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        listView = findViewById(R.id.lvList);

        monanDAO = new MonanDAO(this);

        khoaHocList = monanDAO.getAll();

        dangKyAdapter = new DangKyAdapter(khoaHocList,this,listView);
        listView.setAdapter(dangKyAdapter);
//        show();
    }


//    public void show(){
//        MonanDAO monanDAO = new MonanDAO(DangKyActivity.this);
//        List<KhoaHoc> khoaHocList = monanDAO.getAll();
//        DangKyAdapter  dangKyAdapter =new DangKyAdapter(khoaHocList,DangKyActivity.this);
//        ListView lvList = (ListView)findViewById(R.id.lvList);
//        lvList.setAdapter(dangKyAdapter);
//    }
}
