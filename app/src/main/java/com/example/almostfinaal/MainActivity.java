package com.example.almostfinaal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ConstraintLayout sydney = findViewById(R.id.sydneykl);
        final ConstraintLayout nyc = findViewById(R.id.nyc);
        final ConstraintLayout london = findViewById(R.id.london);
        final ConstraintLayout tokyo = findViewById(R.id.tokyo);
        final ConstraintLayout dubai = findViewById(R.id.dubai);

        final Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView textView = sydney.findViewById(R.id.sydneyk);
                                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy\nh:mm:ss a");
                                String currentDateandTime = sdf.format(new Date());
                                textView.setText(currentDateandTime);

                                TextView sydney1 = sydney.findViewById(R.id.sydneyt2);
                                SimpleDateFormat ldf = new SimpleDateFormat("MMM dd yyyy\nHH:mm:ss");
                                String lDateandTime= ldf.format(new Date());
                                sydney1.setText(lDateandTime);

                                TextView nyct = nyc.findViewById(R.id.nyck);
                                SimpleDateFormat ndf = new SimpleDateFormat("MMM dd yyyy\nh:mm:ss a");
                                ndf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
                                String nycDateandTime = ndf.format(new Date());
                                nyct.setText(nycDateandTime);

                                TextView nyct2 = nyc.findViewById(R.id.nyck2);
                                SimpleDateFormat pdf = new SimpleDateFormat("MMM dd yyyy\nHH:mm:ss");
                                pdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
                                String nycdate2= pdf.format(new Date());
                                nyct2.setText(nycdate2);

                                TextView londont = london.findViewById(R.id.londont);
                                SimpleDateFormat odf = new SimpleDateFormat("MMM dd yyyy\nh:mm:ss a");
                                odf.setTimeZone(TimeZone.getTimeZone("Europe/London"));
                                String londonto = odf.format(new Date());
                                londont.setText(londonto);

                                TextView londont2 = london.findViewById(R.id.londont1);
                                SimpleDateFormat odf2 = new SimpleDateFormat("MMM dd yyyy\nHH:mm:ss");
                                odf2.setTimeZone(TimeZone.getTimeZone("Europe/London"));
                                String londonto2 = odf2.format(new Date());
                                londont2.setText(londonto2);

                                TextView tokyot = tokyo.findViewById(R.id.tokyot);
                                SimpleDateFormat tdf = new SimpleDateFormat("MMM dd yyyy\nh:mm:ss a");
                                tdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
                                String tt = tdf.format(new Date());
                                tokyot.setText(tt);

                                TextView tokyot1 = tokyo.findViewById(R.id.tokyot2);
                                SimpleDateFormat tdf2 = new SimpleDateFormat("MMM dd yyyy\nHH:mm:ss");
                                tdf2.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
                                String tt2 = tdf2.format(new Date());
                                tokyot1.setText(tt2);

                                TextView d = dubai.findViewById(R.id.dubait);
                                SimpleDateFormat ddf = new SimpleDateFormat("MMM dd yyyy\nh:mm:ss a");
                                ddf.setTimeZone(TimeZone.getTimeZone("Asia/Dubai"));
                                String dt = ddf.format(new Date());
                                d.setText(dt);

                                TextView du = dubai.findViewById(R.id.dubait2);
                                SimpleDateFormat ddf2 = new SimpleDateFormat("MMM dd yyyy\nHH:mm:ss");
                                ddf2.setTimeZone(TimeZone.getTimeZone("Asia/Dubai"));
                                String ddft = ddf2.format(new Date());
                                du.setText(ddft);
                            }
                        });
                    }
                } catch (InterruptedException e) {

                }
            }
        };
        t.start();

        Switch switch1 = sydney.findViewById(R.id.switch1);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    TextView textView = sydney.findViewById(R.id.sydneyk);
                    textView.setVisibility(View.INVISIBLE);
                    TextView sydneyt2 = sydney.findViewById(R.id.sydneyt2);
                    sydneyt2.setVisibility(View.VISIBLE);

                    TextView nyck = nyc.findViewById(R.id.nyck);
                    nyck.setVisibility(View.INVISIBLE);
                    TextView nyct2 = nyc.findViewById(R.id.nyck2);
                    nyct2.setVisibility(View.VISIBLE);

                    TextView l1 = london.findViewById(R.id.londont);
                    l1.setVisibility(View.INVISIBLE);
                    TextView l2 = london.findViewById(R.id.londont1);
                    l2.setVisibility(View.VISIBLE);

                    TextView t1 = tokyo.findViewById(R.id.tokyot);
                    t1.setVisibility(View.INVISIBLE);
                    TextView t2 = tokyo.findViewById(R.id.tokyot2);
                    t2.setVisibility(View.VISIBLE);

                    TextView d1 = dubai.findViewById(R.id.dubait);
                    d1.setVisibility(View.INVISIBLE);
                    TextView d2 = dubai.findViewById(R.id.dubait2);
                    d2.setVisibility(View.VISIBLE);
                } else {
                    TextView textView = sydney.findViewById(R.id.sydneyk);
                    textView.setVisibility(View.VISIBLE);
                    TextView sydneyt3 = sydney.findViewById(R.id.sydneyt2);
                    sydneyt3.setVisibility(View.INVISIBLE);

                    TextView nyck = nyc.findViewById(R.id.nyck);
                    nyck.setVisibility(View.VISIBLE);
                    TextView nyct2 = nyc.findViewById(R.id.nyck2);
                    nyct2.setVisibility(View.INVISIBLE);

                    TextView l1 = london.findViewById(R.id.londont);
                    l1.setVisibility(View.VISIBLE);
                    TextView l2 = london.findViewById(R.id.londont1);
                    l2.setVisibility(View.INVISIBLE);

                    TextView t1 = tokyo.findViewById(R.id.tokyot);
                    t1.setVisibility(View.VISIBLE);
                    TextView t2 = tokyo.findViewById(R.id.tokyot2);
                    t2.setVisibility(View.INVISIBLE);

                    TextView d1 = dubai.findViewById(R.id.dubait);
                    d1.setVisibility(View.VISIBLE);
                    TextView d2 = dubai.findViewById(R.id.dubait2);
                    d2.setVisibility(View.INVISIBLE);
                }
            }

            ;
        });
    }
}
