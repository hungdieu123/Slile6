package com.hungviet.slile6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void course(View view) {
        Intent intent
                =new Intent(this,MainActivity.class);startActivity(intent);
    }

    public void maps(View view) {
        Intent intent
                =new Intent(this,NaviActivity.class);startActivity(intent);

    }

    public void news(View view) {
        Intent intent
                =new Intent(this,NewsActivity.class);startActivity(intent);
    }

    public void social(View view) {
        Intent intent
                =new Intent(this,Main2Activity.class);startActivity(intent);
    }
}
