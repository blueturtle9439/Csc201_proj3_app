package com.example.eunhan.csc201_proj3_app;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class q1Activity extends AppCompatActivity implements View.OnClickListener {
    Intent intent;
    String name;
    int q1;

    RadioButton option1;
    RadioButton option2;
    RadioButton option3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);

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

        intent = getIntent();
        name = intent.getStringExtra("info_name");



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pbtn:
                startActivity(new Intent(q1Activity.this, NameActivity.class));
                finish();
                break;
            case R.id.nbtn:
                intent = new Intent(q1Activity.this, q2Activity.class);
                if (option1.isChecked()) {
                    q1 = 1;
                    intent.putExtra("info_name", name);
                    intent.putExtra("info_q1", q1);
                    startActivity(intent);
                } else if (option2.isChecked()) {
                    q1 = 2;
                    intent.putExtra("info_name", name);
                    intent.putExtra("info_q1", q1);
                    startActivity(intent);
                } else if (option3.isChecked()) {
                    q1 = 3;
                    intent.putExtra("info_name", name);
                    intent.putExtra("info_q1", q1);
                    startActivity(intent);
                } else
                    Toast.makeText(q1Activity.this, "please choose one", Toast.LENGTH_SHORT).show();


                break;

            default:
                break;
        }
    }

}