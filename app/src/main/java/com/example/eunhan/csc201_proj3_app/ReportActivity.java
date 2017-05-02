package com.example.eunhan.csc201_proj3_app;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;


import java.sql.*;

public class ReportActivity extends TabActivity implements View.OnClickListener {
    TabHost tabHost;

    public static final String url = "jdbc:postgresql://10.0.2.2:5432/test";
    public static final String usr = "postgres";
    public static final String pwd = "4925";

    int q1 = 0;
    int q1o1 = 0;
    int q1o2 = 0;
    int q1o3 = 0;

    int q2 = 0;
    int q2o1 = 0;
    int q2o2 = 0;
    int q2o3 = 0;

    int q3 = 0;
    int q3o1 = 0;
    int q3o2 = 0;
    int q3o3 = 0;

    LinearLayout graphimage1;
    TextView total1;
    TextView question1;
    TextView actq1o1;
    TextView actq1o1count;
    TextView actq1o1percent;
    TextView actq1o2;
    TextView actq1o2count;
    TextView actq1o2percent;
    TextView actq1o3;
    TextView actq1o3count;
    TextView actq1o3percent;
    Button btn1;

    LinearLayout graphimage2;
    TextView total2;
    TextView question2;
    TextView actq2o1;
    TextView actq2o1count;
    TextView actq2o1percent;
    TextView actq2o2;
    TextView actq2o2count;
    TextView actq2o2percent;
    TextView actq2o3;
    TextView actq2o3count;
    TextView actq2o3percent;
    Button btn2;

    LinearLayout graphimage3;
    TextView total3;
    TextView question3;
    TextView actq3o1;
    TextView actq3o1count;
    TextView actq3o1percent;
    TextView actq3o2;
    TextView actq3o2count;
    TextView actq3o2percent;
    TextView actq3o3;
    TextView actq3o3count;
    TextView actq3o3percent;
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        tabHost = getTabHost();
        LayoutInflater.from(this).inflate(R.layout.activity_report, tabHost.getTabContentView(), true);

        tabHost.addTab(tabHost.newTabSpec("question1")
                .setIndicator("question1")
                .setContent(R.id.q1view));
        tabHost.addTab(tabHost.newTabSpec("question2")
                .setIndicator("question2")
                .setContent(R.id.q2view));
        tabHost.addTab(tabHost.newTabSpec("question3")
                .setIndicator("question3")
                .setContent(R.id.q3view));


        getinfo4survey();
        settab1();
        settab2();
        settab3();



    }

    private void settab1() {
        graphimage1 = (LinearLayout) findViewById(R.id.graphimage1);

        total1 = (TextView) findViewById(R.id.total1);
        question1 = (TextView) findViewById(R.id.question1);
        btn1 = (Button)findViewById(R.id.restartbtn1);

        actq1o1 = (TextView) findViewById(R.id.q1o1);
        actq1o1count = (TextView) findViewById(R.id.q1o1count);
        actq1o1percent = (TextView) findViewById(R.id.q1o1percent);
        actq1o2 = (TextView) findViewById(R.id.q1o2);
        actq1o2count = (TextView) findViewById(R.id.q1o2count);
        actq1o2percent = (TextView) findViewById(R.id.q1o2percent);
        actq1o3 = (TextView) findViewById(R.id.q1o3);
        actq1o3count = (TextView) findViewById(R.id.q1o3count);
        actq1o3percent = (TextView) findViewById(R.id.q1o3percent);


        btn1.setOnClickListener(this);

        total1.setText(String.valueOf(q1));
        question1.setText(getResources().getString(R.string.q1));

        actq1o1.setText(getResources().getString(R.string.q1o1));
        actq1o1count.setText(String.valueOf(q1o1));
        actq1o1percent.setText(String.valueOf(getpercent(q1o1, q1)) + "%");

        actq1o2.setText(getResources().getString(R.string.q1o2));
        actq1o2count.setText(String.valueOf(q1o2));
        actq1o2percent.setText(String.valueOf(getpercent(q1o2, q1)) + "%");

        actq1o3.setText(getResources().getString(R.string.q1o3));
        actq1o3count.setText(String.valueOf(q1o3));
        actq1o3percent.setText(String.valueOf(getpercent(q1o3, q1)) + "%");

        setgraph(graphimage1, q1o1, q1o2, q1o3);
    }
    private void settab2() {
        graphimage2 = (LinearLayout) findViewById(R.id.graphimage2);

        total2 = (TextView) findViewById(R.id.total2);
        question2 = (TextView) findViewById(R.id.question2);
        btn2 = (Button)findViewById(R.id.restartbtn2);
        btn2.setOnClickListener(this);

        actq2o1 = (TextView) findViewById(R.id.q2o1);
        actq2o1count = (TextView) findViewById(R.id.q2o1count);
        actq2o1percent = (TextView) findViewById(R.id.q2o1percent);
        actq2o2 = (TextView) findViewById(R.id.q2o2);
        actq2o2count = (TextView) findViewById(R.id.q2o2count);
        actq2o2percent = (TextView) findViewById(R.id.q2o2percent);
        actq2o3 = (TextView) findViewById(R.id.q2o3);
        actq2o3count = (TextView) findViewById(R.id.q2o3count);
        actq2o3percent = (TextView) findViewById(R.id.q2o3percent);

        total2.setText(String.valueOf(q2));
        question2.setText(getResources().getString(R.string.q2));

        actq2o1.setText(getResources().getString(R.string.q2o1));
        actq2o1count.setText(String.valueOf(q2o1));
        actq2o1percent.setText(String.valueOf(getpercent(q2o1, q2)) + "%");

        actq2o2.setText(getResources().getString(R.string.q2o2));
        actq2o2count.setText(String.valueOf(q2o2));
        actq2o2percent.setText(String.valueOf(getpercent(q2o2, q2)) + "%");

        actq2o3.setText(getResources().getString(R.string.q2o3));
        actq2o3count.setText(String.valueOf(q2o3));
        actq2o3percent.setText(String.valueOf(getpercent(q2o3, q2)) + "%");

        setgraph(graphimage2, q2o1, q2o2, q2o3);


    }
    private void settab3() {
        graphimage3 = (LinearLayout) findViewById(R.id.graphimage3);

        total3 = (TextView) findViewById(R.id.total3);
        question3 = (TextView) findViewById(R.id.question3);
        btn3 = (Button)findViewById(R.id.restartbtn3);
        btn3.setOnClickListener(this);

        actq3o1 = (TextView) findViewById(R.id.q3o1);
        actq3o1count = (TextView) findViewById(R.id.q3o1count);
        actq3o1percent = (TextView) findViewById(R.id.q3o1percent);
        actq3o2 = (TextView) findViewById(R.id.q3o2);
        actq3o2count = (TextView) findViewById(R.id.q3o2count);
        actq3o2percent = (TextView) findViewById(R.id.q3o2percent);
        actq3o3 = (TextView) findViewById(R.id.q3o3);
        actq3o3count = (TextView) findViewById(R.id.q3o3count);
        actq3o3percent = (TextView) findViewById(R.id.q3o3percent);

        total3.setText(String.valueOf(q3));
        question3.setText(getResources().getString(R.string.q3));

        actq3o1.setText(getResources().getString(R.string.q3o1));
        actq3o1count.setText(String.valueOf(q3o1));
        actq3o1percent.setText(String.valueOf(getpercent(q3o1, q3)) + "%");

        actq3o2.setText(getResources().getString(R.string.q3o2));
        actq3o2count.setText(String.valueOf(q3o2));
        actq3o2percent.setText(String.valueOf(getpercent(q3o2, q3)) + "%");

        actq3o3.setText(getResources().getString(R.string.q3o3));
        actq3o3count.setText(String.valueOf(q3o3));
        actq3o3percent.setText(String.valueOf(getpercent(q3o3, q3)) + "%");

        setgraph(graphimage3, q3o1, q3o2, q3o3);



    }

    private int getpercent(int part, int all) {
        return (int) ((double) part / (double) all * 100.0);
    }

    private void setgraph(LinearLayout temp, int v1, int v2, int v3) {

        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setChartTitle("circle graph");
        renderer.setChartTitleTextSize(30);

        int[] values = {v1, v2, v3};

        CategorySeries series = new CategorySeries("insidegraph");
        for (int i = 0; i < values.length; i++) {
            series.add("option" + (i + 1) + "(" + values[i] + ")", values[i]);
        }

        renderer.setLabelsTextSize(15);
        renderer.setLegendTextSize(25);

        int[] colors = {Color.BLUE, Color.MAGENTA, Color.BLACK};

        for (int i = 0; i < colors.length; i++) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(colors[i]);
            renderer.addSeriesRenderer(r);
        }

        renderer.setZoomButtonsVisible(true); // 줌
        renderer.setZoomEnabled(true); // 줌

        GraphicalView view = ChartFactory.getPieChartView(this, series,
                renderer);
        temp.addView(view);

    }

    private void getinfo4survey() {


        new Thread() {
            public void run() {


                try {
                    Class.forName("org.postgresql.Driver");
                    // -- 1
                    System.out.println("b4 conneting");
                    Connection conn = DriverManager.getConnection(url, usr, pwd);


                    //-------------------------------------------------------read from db
                    String sql = "select * from savedinfo";

                    PreparedStatement statement = conn.prepareStatement(sql);
                    ResultSet result = statement.executeQuery();


                    while (result.next()) {
                        String s = result.getString("q_1");
                        if (s.equals("1")) {
                            q1++;
                            q1o1++;
                        } else if (s.equals("2")) {
                            q1++;
                            q1o2++;
                        } else if (s.equals("3")) {
                            q1++;
                            q1o3++;
                        } else {
                            q1++;
                            q1o1++;
                        }

                        String s1 = result.getString("q_2");
                        if (s1.equals("1")) {
                            q2++;
                            q2o1++;
                        } else if (s1.equals("2")) {
                            q2++;
                            q2o2++;
                        } else if (s1.equals("3")) {
                            q2++;
                            q2o3++;
                        } else {
                            q2++;
                            q2o1++;
                        }

                        String s2 = result.getString("q_3");
                        if (s2.equals("1")) {
                            q3++;
                            q3o1++;
                        } else if (s2.equals("2")) {
                            q3++;
                            q3o2++;
                        } else if (s2.equals("3")) {
                            q3++;
                            q3o3++;
                        } else {
                            q3++;
                            q3o1++;
                        }

                    }

                    //-------------------------------------------------------read from db end

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

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.restartbtn1:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            case R.id.restartbtn2:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            case R.id.restartbtn3:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;

            default:
                break;
        }
    }

}