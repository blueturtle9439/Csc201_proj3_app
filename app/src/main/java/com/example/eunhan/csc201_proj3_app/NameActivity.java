package com.example.eunhan.csc201_proj3_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity implements View.OnClickListener {
    EditText nameinput;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        Button pbtn = (Button) findViewById(R.id.pbtn);
        Button nbtn = (Button) findViewById(R.id.nbtn);
        pbtn.setOnClickListener(this);
        nbtn.setOnClickListener(this);
        nameinput = (EditText)findViewById(R.id.nameinput);





    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pbtn:
                startActivity(new Intent(NameActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.nbtn:
                intent = new Intent(NameActivity.this, q1Activity.class) ;
                intent.putExtra("info_name", nameinput.getText().toString()) ;

                startActivity(intent) ;
                break;

            default:
                break;
        }
    }

}