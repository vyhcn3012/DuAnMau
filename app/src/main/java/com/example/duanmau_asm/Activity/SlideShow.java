package com.example.lamthuasm_duanmau.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.lamthuasm_duanmau.R;

public class SlideShow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_show);
    }
    public void openDangNhap(View view){
        Intent Intent = new Intent(SlideShow.this, LoginActivity.class);
        startActivity(Intent);
    }

    public void openDangKy(View view){
        Intent Intent = new Intent(SlideShow.this, RegisterActivity.class);
        startActivity(Intent);
    }
}