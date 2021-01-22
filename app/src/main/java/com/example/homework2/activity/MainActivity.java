package com.example.homework2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

//程序启动的activity，用于判断登陆状态和跳转
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences preferences = this.getSharedPreferences("login", Context.MODE_PRIVATE);
        boolean isRemember = preferences.getBoolean("isRemember", false);
        Intent intent;
        if (isRemember) {
            intent = new Intent(this, TeacherMainActivity.class);
        } else {
            intent = new Intent(this, LoginActivity.class);
        }

        startActivity(intent);
        finish();
        super.onCreate(savedInstanceState);
    }
}