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
                                ndf.setTimeZone(TimeZone.getTimeZone("Europe/London"));
                                String nycDateandTime = ndf.format(new Date());
                                nyct.setText(nycDateandTime);

                                TextView nyct2 = nyc.findViewById(R.id.nyck2);
                                SimpleDateFormat pdf = new SimpleDateFormat("MMM dd yyyy\nHH:mm:ss");
                                pdf.setTimeZone(TimeZone.getTimeZone("Europe/London"));
                                String nycdate2= pdf.format(new Date());
                                nyct2.setText(nycdate2);
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
                } else {
                    TextView textView = sydney.findViewById(R.id.sydneyk);
                    textView.setVisibility(View.VISIBLE);
                    TextView sydneyt3 = sydney.findViewById(R.id.sydneyt2);
                    sydneyt3.setVisibility(View.INVISIBLE);

                    TextView nyck = nyc.findViewById(R.id.nyck);
                    nyck.setVisibility(View.VISIBLE);
                    TextView nyct2 = nyc.findViewById(R.id.nyck2);
                    nyct2.setVisibility(View.INVISIBLE);
                }
            }

            ;
        });
    }
}
