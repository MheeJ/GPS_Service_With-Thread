package com.example.gps_service_mini;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class MainActivity extends AppCompatActivity {

    private Button btnStart, btnEnd, Go_GPSmethods, Go_comfirm;
    public String longitude_list = null;
    public String latitude_list = null;
    public String getLongitude_list;
    public String getLatitude_list;
    public TextView my , kk;
    public ArrayList<String> longitude_Array;
    public ArrayList<String> latitude_Array;


    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = (Button)findViewById(R.id.btn_start);
        btnEnd = (Button)findViewById(R.id.btn_end);
        Go_GPSmethods = (Button)findViewById(R.id.go_gpsmethods);
        Go_comfirm = (Button)findViewById(R.id.gps_enable);

        intent=getIntent();


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Service 시작",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, GPS_Background_Service.class);
                startService(intent);

            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Service 끝",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, GPS_Background_Service.class);
                stopService(intent);

            }
        });

        Go_GPSmethods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GPS_Methods.class);
                startActivity(intent);
            }
        });

       Go_comfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GPS_confirm.class);
                startActivity(intent);
            }
        });


    }

    /*@Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.my_location_method:
                //버튼 클릭시 동작
                *//*    log = intent.getStringExtra( "Now_Longitude");
               lat = intent.getStringExtra("Now_Latitude");
               My_Longtitude_Text.setText(log);
               My_Latitude_Text.setText(lat);*//*
                break;

        }
    }*/
}
