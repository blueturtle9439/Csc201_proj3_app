package com.example.eunhan.csc201_proj3_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;


public class q3Activity extends AppCompatActivity implements View.OnClickListener {
    Intent intent;
    String name;
    int q1;
    int q2;
    int q3;

    RadioButton option1;
    RadioButton option2;
    RadioButton option3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q3);

        Button pbtn = (Button) findViewById(R.id.pbtn);
        Button nbtn = (Button) findViewById(R.id.nbtn);
        pbtn.setOnClickListener(this);
        nbtn.setOnClickListener(this);

        option1 = (RadioButton) findViewById(R.id.option1);
        option2 = (RadioButton) findViewById(R.id.option2);
        option3 = (RadioButton) findViewById(R.id.option3);
        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);

        intent = getIntent() ;
        name = intent.getStringExtra("info_name");
        q1 = intent.getIntExtra("info_q1", 0);
        q2 = intent.getIntExtra("info_q2",0);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pbtn:
                startActivity(new Intent(q3Activity.this, q2Activity.class));
                finish();
                break;
            case R.id.nbtn:
                intent = new Intent(q3Activity.this, resultActivity.class) ;
                if(option1.isChecked()){
                    q3=1;
                    intent.putExtra("info_name", name);
                    intent.putExtra("info_q1", q1);
                    intent.putExtra("info_q2", q2);
                    intent.putExtra("info_q3", q3);
                    startActivity(intent) ;
                }
                else if(option2.isChecked()){
                    q3=2;
                    intent.putExtra("info_name", name);
                    intent.putExtra("info_q1", q1);
                    intent.putExtra("info_q2", q2);
                    intent.putExtra("info_q3", q3);
                    startActivity(intent) ;
                }
                else if(option3.isChecked()){
                    q3=3;
                    intent.putExtra("info_name", name);
                    intent.putExtra("info_q1", q1);
                    intent.putExtra("info_q2", q2);
                    intent.putExtra("info_q3", q3);
                    startActivity(intent) ;
                }
                else
                    Toast.makeText(this, "please choose one", Toast.LENGTH_SHORT).show();


                break;

            default:
                break;
        }
    }

}