package com.example.chao.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.chao.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startPrimaryUserActivity(View view){
        Intent intent = new Intent(this, DisplayPrimaryUserActivity.class);
        startActivity(intent);
    }

    public void startTestUserActivity(View view){
        Intent intent = new Intent(this, DisplayTestUserActivity.class);
        startActivity(intent);
    }
}
