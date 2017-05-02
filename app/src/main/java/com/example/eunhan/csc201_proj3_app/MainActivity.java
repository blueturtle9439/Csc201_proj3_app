package com.example.eunhan.csc201_proj3_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button surveybtn = (Button) findViewById(R.id.surveybtn);
        Button reportbtn = (Button) findViewById(R.id.reportbtn);
        surveybtn.setOnClickListener(this);
        reportbtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.surveybtn:
                startActivity(new Intent(MainActivity.this, NameActivity.class));
                finish();
                break;
            case R.id.reportbtn:
                startActivity(new Intent(MainActivity.this, ReportActivity.class));
                finish();
                break;

            default:
                break;
        }
    }

}

