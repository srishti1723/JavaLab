package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textCounter = findViewById(R.id.textCounter);
        Button startButton = findViewById(R.id.startbtn);
        Button stopButton = findViewById(R.id.stopbtn);

        startButton.setOnClickListener(new View.OnClickListener (){
            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {
                        while (!stopButton.isPressed()) {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                return;
                            }
                            textCounter.post(new Runnable() {
                                public void run() {
                                    textCounter.setText("" + counter++);
                                }
                            });
                        }
                    }
                }).start();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Thread.sleep(500);
                    textCounter.setText(""+counter);
                    Thread.interrupted();
                    counter=0;

                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
    }
}