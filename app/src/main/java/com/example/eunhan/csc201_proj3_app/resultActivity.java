package com.example.eunhan.csc201_proj3_app;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.*;

public class resultActivity extends AppCompatActivity implements View.OnClickListener {
    Intent intent;
    String name;
    int q1;
    int q2;
    int q3;


    public static final String url = "jdbc:postgresql://10.0.2.2:5432/test";
    //https://stackoverflow.com/questions/18341652/connect-failed-econnrefused
    public static final String usr = "postgres";
    public static final String pwd = "4925";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView showingname = (TextView)findViewById(R.id.showingname);
        TextView showingq1 = (TextView)findViewById(R.id.showingq1);
        TextView showingq2 = (TextView)findViewById(R.id.showingq2);
        TextView showingq3 = (TextView)findViewById(R.id.showingq3);

        Button reportbtn = (Button) findViewById(R.id.reportbtn);
        Button restartbtn = (Button) findViewById(R.id.restartbtn);
        reportbtn.setOnClickListener(this);
        restartbtn.setOnClickListener(this);


        intent = getIntent();
        name = intent.getStringExtra("info_name");
        q1 = intent.getIntExtra("info_q1", 0);
        q2 = intent.getIntExtra("info_q2", 0);
        q3 = intent.getIntExtra("info_q3", 0);


        System.out.println(name);
        System.out.println(getq1(q1));
        System.out.println(getq2(q2));
        System.out.println(getq3(q3));

        showingname.setText(name);
        showingq1.setText(getq1(q1));
        showingq2.setText(getq1(q2));
        showingq3.setText(getq1(q3));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reportbtn:



                new Thread() {
                    public void run() {
                        try {
                            Class.forName("org.postgresql.Driver");
                            // -- 1
                            System.out.println("b4 conneting");
                            Connection conn = DriverManager.getConnection(url, usr, pwd);

                                //-------------------------------------------------------write to db
                            String sql = " insert into savedinfo (user_name, q_1, q_2, q_3)"
                                    + " values (?, ?, ?, ?)";

                            // create the mysql insert preparedstatement
                            PreparedStatement preparedStmt = conn.prepareStatement(sql);
                            preparedStmt.setString (1, name);
                            preparedStmt.setInt (2, q1);
                            preparedStmt.setInt (3, q2);
                            preparedStmt.setInt (4, q3);

                            // execute the preparedstatement
                            preparedStmt.execute();

                            //-------------------------------------------------------write to db end

                            System.out.println("after connecting");
                            conn.close();

                        } catch (ClassNotFoundException e) {
                            System.out.print("Error");
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }


                    }
                }.start();


                startActivity(new Intent(resultActivity.this, ReportActivity.class));
                finish();
                break;
            case R.id.restartbtn:
                startActivity(new Intent(resultActivity.this, q1Activity.class));
                finish();
                break;

            default:
                break;
        }
    }


    private String getq1(int i) {
        if (i == 1)
            return getResources().getString(R.string.q1o1);
        else if (i == 2)
            return getResources().getString(R.string.q1o2);
        else if (i == 3)
            return getResources().getString(R.string.q1o3);
        else
            return "0";
    }
    private String getq2(int i) {
        if (i == 1)
            return getResources().getString(R.string.q2o1);
        else if (i == 2)
            return getResources().getString(R.string.q2o2);
        else if (i == 3)
            return getResources().getString(R.string.q2o3);
        else
            return "0";
    }
    private String getq3(int i) {
        if (i == 1)
            return getResources().getString(R.string.q3o1);
        else if (i == 2)
            return getResources().getString(R.string.q3o2);
        else if (i == 3)
            return getResources().getString(R.string.q3o3);
        else
            return "0";
    }

}